package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {

    private Connection connection;
    private Statement statement;

    public MySQLConnection() {

        try {
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conexão - valores para acessar a base de dados
            final String server = "localhost";
            final String database = "clinica_medica";
            final String url = "jdbc:mysql://" + server + ":3306/" + database + "?serverTimezone=UTC&useTimezone=true";
            final String user = "root";
            final String password = "pass";

            // Conectando..
            connection = DriverManager.getConnection(url, user, password);

            // As instruções permitem emitir consultas SQL para o banco de dados
            statement = connection.createStatement();

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: Não concectado!");
            }

        } catch (ClassNotFoundException e) { //Driver não encontrado
            System.out.println("O driver nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
    
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Conexão fechada");
        } catch (SQLException ex) {
            System.out.println("Problema ao fechar conexão");
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            // esse logger ai foi dado pelo netbeans na correção automatica
        }
    }
    
}
