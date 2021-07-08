package controller;

import java.util.List;
import model.business.MedicoBusiness;
import model.entity.Medico;
import model.entity.enums.Consultorio;
import model.entity.enums.Periodo;

public class MedicoController {

    private final MedicoBusiness medicoBusiness;
    private final AgendamentoController agendamentoController;

    public MedicoController() {
        this.medicoBusiness = new MedicoBusiness();
        this.agendamentoController = new AgendamentoController();
    }

    public boolean cadastrar(int crm, String especialidade, String nomePeriodo, String nomeConsultorio, String nome, String telefone) {
        Periodo periodo = Periodo.valueOf(nomePeriodo);
        Consultorio consultorio = Consultorio.valueOf(nomeConsultorio);

        Medico medico = new Medico(crm, especialidade, periodo, consultorio, nome, telefone);
        return medicoBusiness.insertMedicoIntoBD(medico);
    }

    public boolean editar(int crm, String especialidade, String nomePeriodo, String nomeConsultorio, int id, String nome, String telefone) {
        Periodo periodo = Periodo.valueOf(nomePeriodo);
        Consultorio consultorio = Consultorio.valueOf(nomeConsultorio);

        Medico medico = new Medico(crm, telefone, periodo, consultorio, id, nome, telefone);
        return medicoBusiness.updateMedicoInBD(medico);
    }

    public boolean apagar(int id) {
        agendamentoController.deleteAllAgendamentosMedico(id);
        return medicoBusiness.deleteMedicoFromBD(id);
    }

    public List<Medico> getMinhaLista() {
        return medicoBusiness.getMinhaLista();
    }

    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {

        List<Medico> minhaLista = medicoBusiness.getMinhaLista();

        String[][] matrizMedicos = new String[minhaLista.size()][7];

        for (int i = 0; i < minhaLista.size(); i++) {
            matrizMedicos[i][0] = minhaLista.get(i).getId() + "";
            matrizMedicos[i][1] = minhaLista.get(i).getNome();
            matrizMedicos[i][2] = minhaLista.get(i).getTelefone() + "";
            matrizMedicos[i][3] = minhaLista.get(i).getCrm() + "";
            matrizMedicos[i][4] = minhaLista.get(i).getEspecialidade();
            matrizMedicos[i][5] = minhaLista.get(i).getPeriodo().toString();
            matrizMedicos[i][6] = minhaLista.get(i).getConsultorio().toString();
        }
        
        return matrizMedicos;
    }

    public String[][] getMinhaMatrizTexto(String busca) {

        List<Medico> minhaLista = medicoBusiness.getMinhaListaByNome(busca);

        String[][] matrizMedicos = new String[minhaLista.size()][7];

        for (int i = 0; i < minhaLista.size(); i++) {
            matrizMedicos[i][0] = minhaLista.get(i).getId() + "";
            matrizMedicos[i][1] = minhaLista.get(i).getNome();
            matrizMedicos[i][2] = minhaLista.get(i).getTelefone() + "";
            matrizMedicos[i][3] = minhaLista.get(i).getCrm() + "";
            matrizMedicos[i][4] = minhaLista.get(i).getEspecialidade();
            matrizMedicos[i][5] = minhaLista.get(i).getPeriodo().toString();
            matrizMedicos[i][6] = minhaLista.get(i).getConsultorio().toString();
        }
        
        return matrizMedicos;
    }
    
    public int contaMedicosPorPeriodoConsultorio(String periodo, String consultorio) {
        Periodo per = Periodo.valueOf(periodo);
        Consultorio cons = Consultorio.valueOf(consultorio);
        return medicoBusiness.contaMedicosPorPeriodoConsultorio(per, cons);
    }
}
