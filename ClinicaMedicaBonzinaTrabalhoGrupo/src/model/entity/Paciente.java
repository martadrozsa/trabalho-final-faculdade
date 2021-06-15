package model.entity;

import java.util.Date;

public class Paciente extends Pessoa{
    
    private Date dataNascimento;
    private String endereco;
    
    public Paciente() {
    }

    public Paciente(Date dataNascimento, String endereco) {
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public Paciente(int id, String nome, String telefone) {
        super(id, nome, telefone);
    }

    public Paciente(Date dataNascimento, String endereco, String nome, String telefone) {
        super(nome, telefone);
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
 
}