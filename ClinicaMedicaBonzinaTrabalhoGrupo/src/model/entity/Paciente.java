package model.entity;

import java.util.Date;

public class Paciente extends Pessoa{
    
    public Paciente() {
    }

    public Paciente(int id, String nome, Date dataNascimento, String endereco, String telefone) {
        super(id, nome, dataNascimento, endereco, telefone);
    }
    
    public Paciente(String nome, Date dataNascimento, String endereco, String telefone) {
        super(nome, dataNascimento, endereco, telefone);
    }
    
}