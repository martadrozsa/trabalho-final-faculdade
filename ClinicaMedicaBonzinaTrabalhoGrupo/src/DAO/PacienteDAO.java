package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.entity.Paciente;

public class PacienteDAO {
    
    private Connection connection;
    private Statement statement;
      
    public PacienteDAO() {
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
                System.out.println("Status: Não conectado!");
            }
            
        } catch (ClassNotFoundException e) { //Driver não encontrado
            System.out.println("O driver nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
        }
    }    
    
    public List<Paciente> getMinhaListaPacientes(){
        try {
            String query = "SELECT * FROM paciente";

            // Recupera dados da base
            ResultSet resultSet = statement.executeQuery(query);

            List<Paciente> pacientes = parseResultSetToPaciente(resultSet);

            // Todos os pacientes na lista "pacientes"
            return pacientes;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }

    // transforma as rows do database -> objetos em lista local
    // transforma os dados da tabela na base em dados (objetos) em uma lista
    public List<Paciente> parseResultSetToPaciente(ResultSet resultSet) throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String curso = resultSet.getString("nome");
            Date fase = resultSet.getDate("data_nascimento");
            String nome = resultSet.getString("endereco");
            String idade = resultSet.getString("telefone");

            Paciente paciente = new Paciente();
            pacientes.add(paciente);
        }
        return pacientes;
    }
    
    public boolean insertPaciente(Paciente paciente) {
        try {
            String insertStatement = "INSERT INTO paciente(nome, data_nascimento, endereco, telefone) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            
            java.sql.Date sqlDate = new java.sql.Date(paciente.getDataNascimento().getTime());
            
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setString(3, paciente.getEndereco());
            preparedStatement.setString(4, paciente.getTelefone());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception ex) {
            System.out.println("Error while inserting data: " + ex.toString());
            return false;
        }
        return true;
    }
    
    public boolean updatePaciente(Paciente paciente) {
        String updateStatement = "UPDATE paciente SET nome=?, data_nascimento=?, endereco=?, telefone=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
            
            java.sql.Date sqlDate = new java.sql.Date(paciente.getDataNascimento().getTime());
            
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setString(3, paciente.getEndereco());
            preparedStatement.setString(4, paciente.getTelefone());
            preparedStatement.setInt(5, paciente.getId());
            preparedStatement.executeUpdate();
            
            preparedStatement.close();

        } catch (Exception ex) {
            System.out.println("Error while updating data: " + ex.toString());
            return false;
        }
        return true;
    }
      
    public boolean deletePacienteById(int id) {
        try {
            String deleteStatement = "DELETE FROM paciente WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
            preparedStatement.close();

        } catch (Exception ex) {
            System.out.println("Error while deleting data: " + ex.toString());
            return false;
        }
        return true;
    }
    
    // método de pesquisa para a TelaPesquisaView e para a TelaBuscarPacienteView
    public List<Paciente> getMinhaListByNome(String nome) {
        // database, me entrega todos as linhas na tabela paciente que tem o nome parecido com "nome".
        String termoBusca = "%" + nome + "%";
        String queryStatement = "SELECT * FROM paciente WHERE nome LIKE ?";
            
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Paciente> pacientes = parseResultSetToPaciente(resultSet);
            preparedStatement.close();
            // Todos os pacientes na lista "pacientes"
            return pacientes;
            
        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            return new ArrayList<>();
        }
    }
 
}
