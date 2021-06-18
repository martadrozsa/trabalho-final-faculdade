package model.entity;

import java.sql.Time;
import java.util.Date;


public class Agendamento {
    
    int id;
    Date data;
    Time horario;
    int idMedico;
    int idPaciente;

    public Agendamento() {
    }

    public Agendamento(int id, Date data, Time horario, int idMedico, int idPaciente) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }
    
    public Agendamento(Date data, Time horario, int idMedico, int idPaciente) {
        this.data = data;
        this.horario = horario;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    
}
