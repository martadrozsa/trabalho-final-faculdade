package model.business;

import DAO.PacienteDAO;
import java.util.List;
import model.entity.Paciente;

public class PacienteBusiness {

    private final PacienteDAO pacienteDAO;

    public PacienteBusiness() {
        this.pacienteDAO = new PacienteDAO();
    }

    public List<Paciente> getMinhaLista() {
        return pacienteDAO.getMinhaListaPacientes();
    }

    public boolean insertPacienteIntoBD(Paciente paciente) {
        boolean isSuccess = pacienteDAO.insertPaciente(paciente);
        return isSuccess;
    }

    public boolean updatePacienteInBD(Paciente paciente) {
        return pacienteDAO.updatePaciente(paciente);
    }

    public boolean deletePacienteFromBD(int id) {
        return pacienteDAO.deletePacienteById(id);
    }

    public List<Paciente> getMinhaListaByNome(String inputNomePesquisa) {
        return pacienteDAO.getMinhaListByNome(inputNomePesquisa);
    }

    public Paciente getPacienteById(int id) {
        return pacienteDAO.getPacienteById(id);
    }

    public int getCountPacientes() {
        return pacienteDAO.getCountPacientes();
    }

}
