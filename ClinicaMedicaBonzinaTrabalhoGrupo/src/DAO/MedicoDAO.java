package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.entity.Medico;
import model.entity.enums.Consultorio;
import model.entity.enums.Periodo;

public class MedicoDAO {

    //declarando as variáveis. Não estão inicializadas. Até serem inicializadas o valor é null e não podems e utilizadas.
    private Connection connect;
    private Statement statement;
    
    // construtor PacienteDAO
    public MedicoDAO() {
        connectToDatabase("localhost", 3306, "clinica_medica", "root", "pass");
    }
    
    private void connectToDatabase(String ip, int port, String schema, String username, String password) {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionStr = "jdbc:mysql://" + ip + ":" + port + "/" + schema + "?user=" + username + "&password=" + password + "&serverTimezone=UTC";
           
            connect = DriverManager.getConnection(connectionStr);

            // Statements allow to issue SQL queries to the database - usado para fazer as querys
            statement = connect.createStatement();
            
        } catch (Exception ex) {
            System.out.println("Failed to connect to database: " + ex.toString());
        }
    }
    
    public List<Medico> getMinhaListaMedicos(){
        try {
            String query = "SELECT * FROM medico";

            // Recupera dados da base
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
            Date dataNascimento = resultSet.getDate("data_nascimento");
            String endereco = resultSet.getString("endereco");
            String telefone = resultSet.getString("telefone");
            
            //converse tipo String em ENUM
            Periodo periodo = Periodo.valueOf(nomePeriodo);
            Consultorio consultorio = Consultorio.valueOf(nomeConsultorio);
            
            Medico medico = new Medico(crm, especialidade, periodo, consultorio, id, nome, dataNascimento, endereco, telefone);
            medicos.add(medico);
            
        }
        return medicos;
    }
    
    public boolean insertMedico(Medico medico) {
        try {
            String insertStatement = "INSERT INTO medico(crm, especialidade, periodo, consultorio, nome, data_nascimento, endereco, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connect.prepareStatement(insertStatement);
            
            java.sql.Date sqlDate = new java.sql.Date(medico.getDataNascimento().getTime());
            
            //converse tipo
            String periodo = medico.getPeriodo().toString();
            String consultorio = medico.getConsultorio().toString();
                   
            preparedStatement.setInt(1,medico.getCrm());
            preparedStatement.setString(2, medico.getEspecialidade());
            preparedStatement.setString(3, periodo);
            preparedStatement.setString(4, consultorio);
            preparedStatement.setString(5, medico.getNome());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setString(7, medico.getEndereco());
            preparedStatement.setString(8, medico.getTelefone());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception ex) {
            System.out.println("Error while inserting data: " + ex.toString());
            return false;
        }
        return true;
    }
    
    public boolean updateMedico(Medico medico) {
        String updateStatement = "UPDATE medico SET crm=?, especialidade=?, periodo=?, consultorio=?, nome=?, data_nascimento=?, endereco=?, telefone=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(updateStatement);
            
            java.sql.Date sqlDate = new java.sql.Date(medico.getDataNascimento().getTime());
            
            String periodo = medico.getPeriodo().toString();
            String consultorio = medico.getConsultorio().toString();
                   
            preparedStatement.setInt(1,medico.getCrm());
            preparedStatement.setString(2, medico.getEspecialidade());
            preparedStatement.setString(3, periodo);
            preparedStatement.setString(4, consultorio);
            preparedStatement.setString(5, medico.getNome());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setString(7, medico.getEndereco());
            preparedStatement.setString(8, medico.getTelefone());
            
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
            PreparedStatement preparedStatement = connect.prepareStatement(deleteStatement);
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
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
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
 
    public List<Medico> getMinhaListByNomeCompleto(String nome) {
        // database, me entrega todos as linhas na tabela medico que tem a nome = ?
            String queryStatement = "SELECT * FROM medico WHERE nome=?";

        try {  
            PreparedStatement preparedStatement = connect.prepareStatement(queryStatement);
            preparedStatement.setString(1, nome);

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
}