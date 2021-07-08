package model.business;

import DAO.AgendamentoDAO;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.entity.Agendamento;
import model.entity.Medico;
import model.entity.Paciente;
import model.entity.enums.Consultorio;
import model.entity.enums.Periodo;
import static model.entity.enums.Periodo.MATUTINO;

public class AgendamentoBusiness {

    private final AgendamentoDAO agendamentoDAO;
    private final MedicoBusiness medicoBusiness;
    private final PacienteBusiness pacienteBusiness;

    public AgendamentoBusiness() {
        agendamentoDAO = new AgendamentoDAO();
        medicoBusiness = new MedicoBusiness();
        pacienteBusiness = new PacienteBusiness();
    }

    public boolean saveAgendamento(Agendamento agendamento) {
        boolean isSuccess = agendamentoDAO.insertAgendamento(agendamento);
        return isSuccess;
    }

    public boolean deleteAgendamentoFromBD(int id) {
        return agendamentoDAO.deleteAgendamentoById(id);
    }

    public List<Agendamento> getListaAgendamento(Date dataAgendamento) {
        // todosAgendamentos (AgendamentoWrapper) <- todos os slots de agendamentos
        List<Agendamento> todosAgendamentos = new ArrayList<>();

        List<Medico> listaMedico = medicoBusiness.getMedicos();

        // Para cada médico existente na base, cria os slots disponíveis de agendamentos do médico e adiciona na lista de "todos Agendamentos"
        for (int i = 0; i < listaMedico.size(); i++) {

            Medico medico = listaMedico.get(i);
            List<Agendamento> novosAgendamentos = getAgendaMedico(medico, dataAgendamento);
            todosAgendamentos.addAll(novosAgendamentos);
        }

        // agendamentosDoDia (Agendamento) <- slots  de agendamento ocupado
        List<Agendamento> agendamentosDoDia = agendamentoDAO.getAgendamentosDoDiaByDate(dataAgendamento);

        for (int i = 0; i < todosAgendamentos.size(); i++) {
            Agendamento agendamentoVazio = todosAgendamentos.get(i);

            Agendamento agendamentoOcupado = encontraAgendamento(agendamentoVazio, agendamentosDoDia);
            if (agendamentoOcupado == null) {
                continue;
            }

            int idPaciente = agendamentoOcupado.getPaciente().getId();
            Paciente paciente = pacienteBusiness.getPacienteById(idPaciente);
            String nomePaciente = paciente.getNome();
            agendamentoVazio.getPaciente().setNome(nomePaciente);

            agendamentoVazio.getPaciente().setId(idPaciente);

            int idAgendamento = agendamentoOcupado.getIdAgendamento();
            agendamentoVazio.setIdAgendamento(idAgendamento);
        }

        return todosAgendamentos;
    }

    // se encontrar, retorna agendamento; se não, retorna null
    public Agendamento encontraAgendamento(Agendamento agendamento, List<Agendamento> agendamentosDoDia) {

        // buscar um agendamento que tenha um horarioAgendamento e idMedico iguais ao do wrapper.
        // se encontrar, retornar o agendamento. se nao encontrar, retorna null
        for (int i = 0; i < agendamentosDoDia.size(); i++) {
            Agendamento currAgendamento = agendamentosDoDia.get(i);

            if (agendamento.getHorarioAgendamento().equals(currAgendamento.getHorarioAgendamento())
                    && agendamento.getMedico().getId() == currAgendamento.getMedico().getId()) {

                return currAgendamento;
            }
        }

        return null;
    }

    public List<Agendamento> getAgendaMedico(Medico medico, Date dataAgendamento) {

        List<Agendamento> agendamentos = new ArrayList<>();

        String nome = medico.getNome();
        String especialidade = medico.getEspecialidade();
        Consultorio consultorio = medico.getConsultorio();
        Periodo periodoMedico = medico.getPeriodo();
        String nomePaciente = "";
        int idMedico = medico.getId();

        if (periodoMedico.equals(MATUTINO)) {
            for (int i = 7; i <= 12; i++) {
                String currTime = "0" + i + ":00:00";
                Time time = Time.valueOf(currTime);

                Agendamento agendamento = new Agendamento(time, nome, especialidade, consultorio, nomePaciente, idMedico);
                agendamentos.add(agendamento);
            }

        } else {
            for (int i = 13; i <= 18; i++) {
                String currTime = "0" + i + ":00:00";
                Time time = Time.valueOf(currTime);
                Agendamento agendamento = new Agendamento(time, nome, especialidade, consultorio, nomePaciente, idMedico);
                agendamentos.add(agendamento);
            }
        }

        return agendamentos;
    }

    // verifica se tem nome e date, se houver nome e date, chama o metodo no DAO que tem nome e date
    // se houver apenas o nome, chama o metodo do DAO que tem nome
    // se houuver apenas date, chama o metodo do DAO que tem date
    public List<Agendamento> getListaAgendamento(String nome, Date dataAgendamento) {

        if (dataAgendamento != null && nome != null && !nome.equals("")) {
            return agendamentoDAO.getAgendamentosDoDiaByNomeEByData(nome, dataAgendamento);

        } else if (dataAgendamento != null) {
            return agendamentoDAO.getAgendamentosDoDiaByDate(dataAgendamento);

        } else if (nome != null && !nome.equals("")) {
            return agendamentoDAO.getAgendamentosDoDiaByNome(nome);

        } else {
            return new ArrayList<>();
        }
    }

    public int contaAgendamentosPaciente(int idPaciente) {
        return agendamentoDAO.contaAgendamentosDoPaciente(idPaciente);
    }

    public void deleteAllAgendamentosPaciente(int idPaciente) {
        agendamentoDAO.deleteAllAgendamentosPaciente(idPaciente);
    }

    public int contaAgendamentosMedico(int idMedico) {
        return agendamentoDAO.contaAgendamentosDoMedico(idMedico);
    }

    public void deleteAllAgendamentosMedico(int idMedico) {
        agendamentoDAO.deleteAllAgendamentosMedico(idMedico);
    }

    public int getCountTotalSchedules() {
        return agendamentoDAO.getCountTotalSchedules();
    }
}
