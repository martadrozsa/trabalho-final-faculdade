package controller;

import static controller.AgendamentoController.DadosMatrizAgendamento.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import model.business.AgendamentoBusiness;
import model.entity.Agendamento;
import model.entity.enums.Consultorio;

public class AgendamentoController {

    private final AgendamentoBusiness agendamentoBusinnes;

    public AgendamentoController() {
        agendamentoBusinnes = new AgendamentoBusiness();
    }

    public boolean cadastrarAgendamento(Date dataAgendamento, Time horarioAgendamento, int idMedico, int idPaciente) {
        Agendamento agendamento = new Agendamento(dataAgendamento, horarioAgendamento, idMedico, idPaciente);
        return agendamentoBusinnes.saveAgendamento(agendamento);
    }

    public boolean apagarAgendamento(int id) {
        return agendamentoBusinnes.deleteAgendamentoFromBD(id);
    }

    // usado pela tela de agendamento
    public String[][] getAgendamentosByDate(Date dataAgendamento) {

        List<Agendamento> listaAgendamentos = agendamentoBusinnes.getListaAgendamento(dataAgendamento);
        String[][] matrizAgendamentos = new String[listaAgendamentos.size()][8];

        for (int i = 0; i < listaAgendamentos.size(); i++) {

            Agendamento agendamento = listaAgendamentos.get(i);

            Consultorio cons = agendamento.getMedico().getConsultorio();
            String consultorio = cons.getNomeFormatado();

            matrizAgendamentos[i][HORARIO.ordinal()] = agendamento.getHorarioAgendamento() + "";
            matrizAgendamentos[i][NOME_MEDICO.ordinal()] = agendamento.getMedico().getNome() + "";
            matrizAgendamentos[i][ESPECIALIDADE.ordinal()] = agendamento.getMedico().getEspecialidade() + "";
            matrizAgendamentos[i][CONSULTORIO.ordinal()] = consultorio;
            matrizAgendamentos[i][NOME_PACIENTE.ordinal()] = agendamento.getPaciente().getNome() + "";

            matrizAgendamentos[i][ID_MEDICO.ordinal()] = agendamento.getMedico().getId() + "";
            matrizAgendamentos[i][ID_AGENDAMENTO.ordinal()] = agendamento.getIdAgendamento() + "";
            matrizAgendamentos[i][ID_PACIENTE.ordinal()] = agendamento.getPaciente().getId() + "";
        }

        return matrizAgendamentos;
    }

    // usado pela tela de consulta agendamento
    public String[][] getAgendamentosByDateConsulta(String nome, Date dataAgendamento) {

        List<Agendamento> listaAgendamentos = agendamentoBusinnes.getListaAgendamento(nome, dataAgendamento);
        String[][] matrizAgendamentos = new String[listaAgendamentos.size()][10];

        for (int i = 0; i < listaAgendamentos.size(); i++) {

            Agendamento agendamento = listaAgendamentos.get(i);

            Consultorio cons = agendamento.getMedico().getConsultorio();
            String consultorio = cons.getNomeFormatado();

            matrizAgendamentos[i][HORARIO.ordinal()] = agendamento.getHorarioAgendamento() + "";
            matrizAgendamentos[i][NOME_MEDICO.ordinal()] = agendamento.getMedico().getNome() + "";
            matrizAgendamentos[i][ESPECIALIDADE.ordinal()] = agendamento.getMedico().getEspecialidade() + "";
            matrizAgendamentos[i][CONSULTORIO.ordinal()] = consultorio;
            matrizAgendamentos[i][NOME_PACIENTE.ordinal()] = agendamento.getPaciente().getNome() + "";
            matrizAgendamentos[i][ID_MEDICO.ordinal()] = agendamento.getMedico().getId() + "";
            matrizAgendamentos[i][ID_AGENDAMENTO.ordinal()] = agendamento.getIdAgendamento() + "";
            matrizAgendamentos[i][ID_PACIENTE.ordinal()] = agendamento.getPaciente().getId() + "";
            matrizAgendamentos[i][DATA_NASCIMENTO.ordinal()] = agendamento.getPaciente().getDataNascimento() + "";
            matrizAgendamentos[i][DATA_AGENDAMENTO.ordinal()] = agendamento.getDataAgendamento() + "";
        }
        
        return matrizAgendamentos;
    }

    public enum DadosMatrizAgendamento {
        HORARIO,
        NOME_MEDICO,
        ESPECIALIDADE,
        CONSULTORIO,
        NOME_PACIENTE,
        ID_MEDICO,
        ID_AGENDAMENTO,
        ID_PACIENTE,
        DATA_NASCIMENTO,
        DATA_AGENDAMENTO,
    }

    public int contaAgendamentosPaciente(int idPaciente) {
        return agendamentoBusinnes.contaAgendamentosPaciente(idPaciente);
    }

    public void deleteAllAgendamentosPaciente(int idPaciente) {
        agendamentoBusinnes.deleteAllAgendamentosPaciente(idPaciente);
    }

    public int contaAgendamentosMedico(int idMedico) {
        return agendamentoBusinnes.contaAgendamentosMedico(idMedico);
    }

    public void deleteAllAgendamentosMedico(int idMedico) {
        agendamentoBusinnes.deleteAllAgendamentosMedico(idMedico);
    }

    public int getCountTotalSchedules() {
        return agendamentoBusinnes.getCountTotalSchedules();
    }
}
