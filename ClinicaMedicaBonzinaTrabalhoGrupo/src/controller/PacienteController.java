package controller;

import java.util.Date;
import java.util.List;
import model.business.PacienteBusiness;
import model.entity.Paciente;

public class PacienteController {
    private final PacienteBusiness pacienteBusiness;

    public PacienteController() {
        this.pacienteBusiness = new PacienteBusiness();
    }

    public boolean cadastrar(String nome, Date dataNascimento, String endereco, String telefone) {
        Paciente paciente = new Paciente(dataNascimento, endereco, nome, telefone);
        return pacienteBusiness.insertPacienteIntoBD(paciente);
    }

    public boolean editar(String nome, Date dataNascimento, String endereco, String telefone) {
        Paciente paciente = new Paciente();
        return pacienteBusiness.updatePacienteInBD(paciente);
    }

    public boolean apagar(int id) {
        return pacienteBusiness.deletePacienteFromBD(id);
    }

    public List<Paciente> getMinhaLista() {
        return pacienteBusiness.getMinhaLista();
    }
    
    @SuppressWarnings("unchecked")
    public String[][] getMinhaMatrizTexto() {
        List<Paciente> minhalista = pacienteBusiness.getMinhaLista();
        int tamanho = minhalista.size();
        String[][] matrizPacientes = new String[tamanho][5];
        for (int i = 0; i < tamanho; i++) {
            matrizPacientes[i][0] = minhalista.get(i).getId() + "";
            matrizPacientes[i][1] = minhalista.get(i).getNome();
            matrizPacientes[i][2] = minhalista.get(i).getDataNascimento() + "";
            matrizPacientes[i][3] = minhalista.get(i).getEndereco();
            matrizPacientes[i][4] = minhalista.get(i).getTelefone() + "";
        }
        return matrizPacientes;
    }
}
