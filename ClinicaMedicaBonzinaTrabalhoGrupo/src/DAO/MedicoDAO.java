package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.Medico;
import model.entity.enums.Consultorio;
import model.entity.enums.Periodo;

public class MedicoDAO {

    private final MySQLConnection mySQLConn;

    public MedicoDAO() {
        this.mySQLConn = MySQLConnection.getInstance();
    }

    public List<Medico> getMinhaListaMedicos() {
        try {
            String query = "SELECT * FROM medico ORDER BY periodo ASC, consultorio ASC";

            // Recupera dados da base
            Statement statement = mySQLConn.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            List<Medico> medicos = parseResultSetToMedico(resultSet);

            // Todos os pacientes na lista "pacientes"
            return medicos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            
            return new ArrayList<>();
        }
    }

    // transforma as rows do database -> objetos em lista local
    // transforma os dados da tabela na base em dados (objetos) em uma lista
    // cada iteração no while está parseando uma linha do tabela 
    public List<Medico> parseResultSetToMedico(ResultSet resultSet) throws SQLException {
        List<Medico> medicos = new ArrayList<>();

        while (resultSet.next()) {
            int crm = resultSet.getInt("crm");
            String especialidade = resultSet.getString("especialidade");
            String nomePeriodo = resultSet.getString("periodo");
            String nomeConsultorio = resultSet.getString("consultorio");
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String telefone = resultSet.getString("telefone");

            //converse tipo String em ENUM
            Periodo periodo = Periodo.valueOf(nomePeriodo);
            Consultorio consultorio = Consultorio.valueOf(nomeConsultorio);

            Medico medico = new Medico(crm, especialidade, periodo, consultorio, id, nome, telefone);
            medicos.add(medico);

        }
        return medicos;
    }

    public boolean insertMedico(Medico medico) {
        try {
            String insertStatement = "INSERT INTO medico(crm, especialidade, periodo, consultorio, nome, telefone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(insertStatement);

            //converse tipo
            String periodo = medico.getPeriodo().toString();
            String consultorio = medico.getConsultorio().toString();

            preparedStatement.setInt(1, medico.getCrm());
            preparedStatement.setString(2, medico.getEspecialidade());
            preparedStatement.setString(3, periodo);
            preparedStatement.setString(4, consultorio);
            preparedStatement.setString(5, medico.getNome());
            preparedStatement.setString(6, medico.getTelefone());

            preparedStatement.executeUpdate();
            preparedStatement.close();
       
        } catch (Exception ex) {
            System.out.println("Error while inserting data: " + ex.toString());
           
            return false;
        }
        
        return true;
    }

    public boolean updateMedico(Medico medico) {
        String updateStatement = "UPDATE medico SET crm=?, especialidade=?, periodo=?, consultorio=?, nome=?, telefone=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(updateStatement);

            String periodo = medico.getPeriodo().toString();
            String consultorio = medico.getConsultorio().toString();

            preparedStatement.setInt(1, medico.getCrm());
            preparedStatement.setString(2, medico.getEspecialidade());
            preparedStatement.setString(3, periodo);
            preparedStatement.setString(4, consultorio);
            preparedStatement.setString(5, medico.getNome());
            preparedStatement.setString(6, medico.getTelefone());
            preparedStatement.setInt(7, medico.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception ex) {
            System.out.println("Error while updating data: " + ex.toString());
            
            return false;
        }
        
        return true;
    }

    public boolean deleteMedicoById(int id) {
        try {
            String deleteStatement = "DELETE FROM medico WHERE id=?";
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

    public List<Medico> getMinhaListByNome(String nome) {
        // database, me entrega todos as linhas na tabela medico que tem o nome parecido com "nome".
        String termoBusca = "%" + nome + "%";
        String queryStatement = "SELECT * FROM medico WHERE nome LIKE ?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Medico> medicos = parseResultSetToMedico(resultSet);
            preparedStatement.close();
            
            // Todos os pacientes na lista "pacientes"
            return medicos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            
            return new ArrayList<>();
        }
    }
    
    private int parseTotalMedicos(ResultSet resultSet) throws SQLException {
        int totalAgendamentos = -1;
        
        while (resultSet.next()) {
            totalAgendamentos = resultSet.getInt("total");
        }

        return totalAgendamentos;
    }
    
    public int contaMedicosPorPeriodoConsultorio(Periodo periodo, Consultorio consultorio) {
        String queryStatement = "SELECT COUNT(*) as total from medico WHERE consultorio=? and periodo=?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);
            preparedStatement.setString(1, consultorio.toString());
            preparedStatement.setString(2, periodo.toString());

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();
            int total = parseTotalMedicos(resultSet);
            preparedStatement.close();
            
            return total;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            
            return -1;
        }
    }

}
