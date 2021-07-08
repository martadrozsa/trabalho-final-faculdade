package model.business;

import DAO.MedicoDAO;
import java.util.List;
import model.entity.Medico;
import model.entity.enums.Consultorio;
import model.entity.enums.Periodo;

public class MedicoBusiness {

    private final MedicoDAO medicoDAO;

    public MedicoBusiness() {
        this.medicoDAO = new MedicoDAO();
    }

    public List<Medico> getMinhaLista() {
        return medicoDAO.getMinhaListaMedicos();
    }

    public List<Medico> getMinhaListaByNome(String nome) {
        return medicoDAO.getMinhaListByNome(nome);
    }

    public boolean insertMedicoIntoBD(Medico medico) {
        boolean isSuccess = medicoDAO.insertMedico(medico);
        return isSuccess;
    }

    public boolean updateMedicoInBD(Medico medico) {
        return medicoDAO.updateMedico(medico);
    }

    public boolean deleteMedicoFromBD(int id) {
        return medicoDAO.deleteMedicoById(id);
    }

    // retorna todos os médicos
    public List<Medico> getMedicos() {
        return medicoDAO.getMinhaListaMedicos();
    }
    
    public int contaMedicosPorPeriodoConsultorio(Periodo periodo, Consultorio consultorio) {
        return medicoDAO.contaMedicosPorPeriodoConsultorio(periodo, consultorio);
    }
}
