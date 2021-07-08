package model.entity;

import model.entity.enums.Consultorio;
import model.entity.enums.Periodo;

public class Medico extends Pessoa {

    private int crm;
    private String especialidade;
    private Periodo periodo;
    private Consultorio consultorio;

    public Medico() {
    }

    public Medico(int crm, String especialidade, Periodo periodo, Consultorio consultorio, int id, String nome, String telefone) {
        super(id, nome, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
        this.periodo = periodo;
        this.consultorio = consultorio;
    }

    public Medico(int crm, String especialidade, Periodo periodo, Consultorio consultorio, String nome, String telefone) {
        super(nome, telefone);
        this.crm = crm;
        this.especialidade = especialidade;
        this.periodo = periodo;
        this.consultorio = consultorio;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        String output
                = "CRM: " + getCrm()
                + "\nEspecialidade: " + getEspecialidade()
                + "Período: " + getPeriodo()
                + "\nConsultório: " + getConsultorio()
                + "\n" + super.toString();
        return output;
    }

}
