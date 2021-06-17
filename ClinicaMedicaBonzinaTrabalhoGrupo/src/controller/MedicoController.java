package controller;

import java.util.Date;
import java.util.List;
import model.business.MedicoBusiness;
import model.entity.Medico;
import model.entity.Paciente;
import model.entity.enums.Consultorio;
import model.entity.enums.Periodo;

public class MedicoController {
     private final MedicoBusiness medicoBusiness;

    public MedicoController() {
        this.medicoBusiness = new MedicoBusiness();
    }

    public boolean cadastrar(int crm, String especialidade, String nomePeriodo, String nomeConsultorio, String nome, String telefone) {
        Periodo periodo = Periodo.valueOf(nomePeriodo);
        Consultorio consultorio = Consultorio.valueOf(nomeConsultorio);
        
        Medico medico = new Medico(crm, telefone, periodo, consultorio, nome, telefone);
        return medicoBusiness.insertMedicoIntoBD(medico);
    }

    public boolean editar(int crm, String especialidade, String nomePeriodo, String nomeConsultorio, String nome, String telefone) {
        Periodo periodo = Periodo.valueOf(nomePeriodo);
        Consultorio consultorio = Consultorio.valueOf(nomeConsultorio);
        
        Medico medico = new Medico(crm, telefone, periodo, consultorio, nome, telefone);
        return medicoBusiness.updateMedicoInBD(medico);
    }

    public boolean apagar(int id) {
        return medicoBusiness.deleteMedicoFromBD(id);
    }

    public List<Medico> getMinhaLista() {
        return medicoBusiness.getMinhaLista();
    }
    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        
        List<Medico> minhalista = medicoBusiness.getMinhaLista();
        
        String[][] matrizMedicos = new String[minhalista.size()][5];
        
        for (int i = 0; i < minhalista.size(); i++) {
            matrizMedicos[i][0] = minhalista.get(i).getId() + "";
            matrizMedicos[i][1] = minhalista.get(i).getNome();
            matrizMedicos[i][2] = minhalista.get(i).getTelefone() + "";
            matrizMedicos[i][3] = minhalista.get(i).getCrm() + "";
            matrizMedicos[i][4] = minhalista.get(i).getEspecialidade();
            matrizMedicos[i][5] = minhalista.get(i).getPeriodo().toString();
            matrizMedicos[i][6] = minhalista.get(i).getConsultorio().toString();   
        }
        return matrizMedicos;
    }
    
    // transformando os dados da base em uma matriz de texto para imprimir na tela
    // método de pesquisa para a TelaPesquisaView e para a TelaBuscarPacienteView
    public String[][] getMinhaMatrizTexto(String inputPesquisa) {
        
        List<Medico> minhalista = medicoBusiness.getMinhaListaByNome(inputPesquisa);
        
        String[][] matrizMedicos = new String[minhalista.size()][5];
        
        for (int i = 0; i < minhalista.size(); i++) {
            matrizMedicos[i][0] = minhalista.get(i).getId() + "";
            matrizMedicos[i][1] = minhalista.get(i).getNome();
            matrizMedicos[i][2] = minhalista.get(i).getTelefone();
            matrizMedicos[i][3] = minhalista.get(i).getCrm() + "";
            matrizMedicos[i][4] = minhalista.get(i).getEspecialidade();
            matrizMedicos[i][5] = minhalista.get(i).getPeriodo().toString();
            matrizMedicos[i][6] = minhalista.get(i).getConsultorio().toString();   
        }
        return matrizMedicos;
    }
    
}
