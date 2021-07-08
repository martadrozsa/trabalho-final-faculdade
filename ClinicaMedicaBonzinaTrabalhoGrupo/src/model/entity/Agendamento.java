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

    public Agendamento(
            Time horarioAgendamento,
            String nomeMedico,
            String especialidade,
            Consultorio consultorio,
            String nomePaciente,
            int idMedico) {
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

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
