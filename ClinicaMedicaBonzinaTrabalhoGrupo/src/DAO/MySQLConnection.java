package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static MySQLConnection uniqueInstance;
    private static Connection connection;

    private MySQLConnection() {
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

    public static MySQLConnection getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MySQLConnection();
        }

        return uniqueInstance;
    }

    public Connection getConnection() {
        return connection;
    }

}
