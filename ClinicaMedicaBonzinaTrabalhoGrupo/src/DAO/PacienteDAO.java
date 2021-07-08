package DAO;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.entity.Paciente;

public class PacienteDAO {

    private final MySQLConnection mySQLConn;

    public PacienteDAO() {
        this.mySQLConn = MySQLConnection.getInstance();

    }

    public List<Paciente> getMinhaListaPacientes() {
        try {
            String query = "SELECT * FROM paciente";

            // Recupera dados da base
            Statement statement = mySQLConn.getConnection().createStatement();
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
            String nome = resultSet.getString("nome");
            Date dataNascimento = resultSet.getDate("data_nascimento");
            String endereco = resultSet.getString("endereco");
            String telefone = resultSet.getString("telefone");

            Paciente paciente = new Paciente(dataNascimento, endereco, id, nome, telefone);
            pacientes.add(paciente);
        }
        return pacientes;
    }

    public boolean insertPaciente(Paciente paciente) {
        String insertStatement = "INSERT INTO paciente(nome, data_nascimento, endereco, telefone) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(insertStatement);

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
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(updateStatement);

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
        String deleteStatement = "DELETE FROM paciente WHERE id=?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(deleteStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (Exception ex) {
            System.out.println("Error while deleting data: " + ex.toString());
            
            return false;
        }
        
        return true;
    }

    public List<Paciente> getMinhaListByNome(String nome) {
        // database, me entrega todos as linhas na tabela paciente que tem o nome parecido com "nome".
        String termoBusca = "%" + nome + "%";
        String queryStatement = "SELECT * FROM paciente WHERE nome LIKE ? ORDER BY nome";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);
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

    public Paciente getPacienteById(int id) {
        String queryStatement = "SELECT * FROM paciente WHERE id=?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Paciente> pacientes = parseResultSetToPaciente(resultSet);
            preparedStatement.close();

            if (pacientes.size() > 0) {
                return pacientes.get(0);
            }
            return null;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            
            return null;
        }
    }

    public int getCountPacientes() {
        String queryStatement = "SELECT COUNT(*) as total FROM paciente";
        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection()
                    .prepareStatement(queryStatement);

            ResultSet resultSet = preparedStatement.executeQuery();

            int totalAgendamentos = -1;

            while (resultSet.next()) {
                totalAgendamentos = resultSet.getInt("total");
            }

            preparedStatement.close();

            return totalAgendamentos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            
            return -1;
        }
    }
}
