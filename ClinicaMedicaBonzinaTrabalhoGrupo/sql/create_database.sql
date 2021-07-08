CREATE DATABASE clinica_medica;
USE clinica_medica;

CREATE TABLE medico (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    crm INT NOT NULL,
    especialidade VARCHAR(50) NOT NULL,
    periodo ENUM('MATUTINO', 'VESPERTINO') NOT NULL,
    consultorio ENUM('CONSULTORIO_1', 'CONSULTORIO_2')NOT NULL,
    telefone VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE paciente (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(10) NOT NULL,
    PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE agendamento (
    id INT NOT NULL AUTO_INCREMENT,
    horario TIME NOT NULL,
    data DATE NOT NULL,
    id_medico INT NOT NULL,
    id_paciente INT NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES medico(id),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id),
    PRIMARY KEY (id)
)ENGINE=InnoDB;