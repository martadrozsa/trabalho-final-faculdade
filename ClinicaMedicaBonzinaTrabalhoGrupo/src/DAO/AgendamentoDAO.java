package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AgendamentoDAO {

    private Connection connection;
    private Statement statement;

    public AgendamentoDAO() {
        connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            
            // Configurar a conexão - valores para acessar a base de dados
            final String server = "localhost";
            final String database = "clinica_medica";
            final String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
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
                System.out.println("Status: NÃO CONECTADO!");
            }
            
        } catch (ClassNotFoundException e) { //Driver não encontrado
            System.out.println("O driver nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
        }
    }
}