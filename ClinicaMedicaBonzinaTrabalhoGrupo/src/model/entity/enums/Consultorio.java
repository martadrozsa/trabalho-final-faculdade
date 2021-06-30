package model.entity.enums;

public enum Consultorio {
    CONSULTORIO_1("Consultório 1"),
    CONSULTORIO_2("Consultório 2")
    ;
    
    private String nomeFormatado;
    
    Consultorio(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }
    
    public String getNomeFormatado() {
        return nomeFormatado;
    }
}
