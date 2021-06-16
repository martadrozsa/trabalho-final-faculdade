package model.business;

import DAO.MedicoDAO;
import java.util.List;
import model.entity.Medico;


public class MedicoBusiness {
    private MedicoDAO medicoDAO;

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
}
