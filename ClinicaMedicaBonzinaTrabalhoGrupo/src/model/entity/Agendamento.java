package model.entity;

import java.sql.Time;
import java.util.Date;
import model.entity.enums.Consultorio;


public class Agendamento {
    
    private int idAgendamento;
    private Date dataAgendamento;
    private Time horarioAgendamento;
    private Medico medico;
    private Paciente paciente;
    
    public Agendamento() {
    }

    public Agendamento(Time horarioAgendamento, String nomeMedico, String especialidade, Consultorio consultorio, String nomePaciente, int idMedico) {
        medico = new Medico();
        paciente = new Paciente();

        this.horarioAgendamento = horarioAgendamento;
        medico.setNome(nomeMedico);
        medico.setEspecialidade(especialidade);
        medico.setConsultorio(consultorio);
        paciente.setNome(nomePaciente); 
        medico.setId(idMedico);
    }

    public Agendamento(
            String nomePaciente,
            Date dataNascimento,
            Time horarioAgendamento,
            Date dataAgendamento,
            int idMedico,
            String nomeMedico,
            Consultorio consultorio,
            int idAgendamento,
            int idPaciente
    ) {
        medico = new Medico();
        paciente = new Paciente();
        
        paciente.setNome(nomePaciente); 
        paciente.setDataNascimento(dataNascimento);
        this.horarioAgendamento = horarioAgendamento;
        this.dataAgendamento = dataAgendamento;
        medico.setId(idMedico);
        medico.setNome(nomeMedico);
        medico.setConsultorio(consultorio);
        this.idAgendamento = idAgendamento;
        paciente.setId(idPaciente);
    }

    public Agendamento(Date dataAgendamento, Time horarioAgendamento, int idMedico, int idPaciente) {
        medico = new Medico();
        paciente = new Paciente();
        this.dataAgendamento = dataAgendamento;
        this.horarioAgendamento = horarioAgendamento;
        medico.setId(idMedico);
        paciente.setId(idPaciente);
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
  
    public Time getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(Time horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }
    
    public int getIdMedico() {
        return medico.getId();
    }

    public void setIdMedico(int idMedico) {
        medico.setId(idMedico);
    }

    public String getNomeMedico() {
        return medico.getNome();
    }

    public void setNomeMedico(String nomeMedico) {
        medico.setNome(nomeMedico);
    }

    public String getEspecialidade() {
        return medico.getEspecialidade();
    }

    public void setEspecialidade(String especialidade) {
        medico.setEspecialidade(especialidade);
    }

    public Consultorio getConsultorio() {
        return medico.getConsultorio();
    }

    public void setConsultorio(Consultorio consultorio) {
        medico.setConsultorio(consultorio);
    }
    
    public int getIdPaciente() {
        return paciente.getId();
    }

    public void setIdPaciente(int idPaciente) {
        paciente.setId(idPaciente);
    }
    
    public String getNomePaciente() {
        return paciente.getNome();
    }

    public void setNomePaciente(String nomePaciente) {
        paciente.setNome(nomePaciente); 
    }
    
    public Date getDataNascimento() {
        return paciente.getDataNascimento();
    }

    public void setDataNascimento(Date dataNascimento) {
        paciente.setDataNascimento(dataNascimento);
    }
}
