package model.entity;

import java.util.Date;

public class Paciente extends Pessoa {

    private Date dataNascimento;
    private String endereco;

    public Paciente() {
    }

    public Paciente(Date dataNascimento, String endereco, int id, String nome, String telefone) {
        super(id, nome, telefone);
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
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

    @Override
    public String toString() {
        String output
                = "Data de Nascimento: " + getDataNascimento()
                + "\nEndereço: " + getEndereco()
                + "\n"
                + super.toString();
        return output;
    }

}
