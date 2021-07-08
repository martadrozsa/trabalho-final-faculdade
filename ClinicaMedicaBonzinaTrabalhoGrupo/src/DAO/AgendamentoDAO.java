package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.entity.Agendamento;
import model.entity.enums.Consultorio;

public class AgendamentoDAO {

    private final MySQLConnection mySQLConn;

    public AgendamentoDAO() {
        this.mySQLConn = MySQLConnection.getInstance();
    }

    public boolean insertAgendamento(Agendamento agendamento) {
        String insertStatement = "INSERT INTO agendamento (horario, data, id_medico, id_paciente) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(insertStatement);

            java.sql.Date sqlDate = new java.sql.Date(agendamento.getDataAgendamento().getTime());

            preparedStatement.setTime(1, agendamento.getHorarioAgendamento());
            preparedStatement.setDate(2, sqlDate);
            preparedStatement.setInt(3, agendamento.getMedico().getId());
            preparedStatement.setInt(4, agendamento.getPaciente().getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception ex) {
            System.out.println("Error while inserting data: " + ex.toString());
            return false;
        }

        return true;
    }

    public boolean deleteAgendamentoById(int id) {
        try {
            String deleteStatement = "DELETE FROM agendamento WHERE id=?";
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(deleteStatement);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error while deleting data: " + ex.toString());
            return false;
        }

        return true;
    }

    // transforma as rows do database -> objetos em lista local
    // transforma os dados vindos das tabelas Agendamento, Médico e paciente na base em dados (objetos) em uma lista
    private List<Agendamento> parseResultSetToAgendamentoConsulta(ResultSet resultSet) throws SQLException {
        List<Agendamento> agendamentos = new ArrayList<>();

        while (resultSet.next()) {
            String nomePaciente = resultSet.getString("nome_paciente");
            Date dataNascimento = resultSet.getDate("data_nascimento");
            Time horarioAgendamento = resultSet.getTime("horario");
            Date dataAgendamento = resultSet.getDate("data");
            String nomeMedico = resultSet.getString("nome_medico");
            String nomeConsultorio = resultSet.getString("consultorio");
            int idAgendamento = resultSet.getInt("id_agendamento");
            int idPaciente = resultSet.getInt("id_paciente");
            int idMedico = resultSet.getInt("id_medico");

            Consultorio consultorio = Consultorio.valueOf(nomeConsultorio);

            Agendamento agendamento = new Agendamento(
                    nomePaciente, 
                    dataNascimento, 
                    horarioAgendamento, 
                    dataAgendamento, 
                    idMedico, 
                    nomeMedico, 
                    consultorio, 
                    idAgendamento, 
                    idPaciente);
            
            agendamentos.add(agendamento);
        }

        return agendamentos;
    }

    public List<Agendamento> getAgendamentosDoDiaByDate(Date dataAgendamento) {

        String queryStatement = "SELECT age.id as id_agendamento, pe.nome as nome_paciente, pe.data_nascimento, horario, data,me.id as id_medico, me.nome as nome_medico, me.consultorio, pe.id as id_paciente "
                + "FROM agendamento as age "
                + "JOIN medico as me ON age.id_medico=me.id "
                + "JOIN paciente as pe ON age.id_paciente=pe.id "
                + "WHERE data=?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);

            java.sql.Date sqlDate = new java.sql.Date(dataAgendamento.getTime());

            preparedStatement.setDate(1, sqlDate);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Agendamento> agendamentos = parseResultSetToAgendamentoConsulta(resultSet);
            preparedStatement.close();

            return agendamentos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());

            return new ArrayList<>();
        }
    }

    public List<Agendamento> getAgendamentosDoDiaByNome(String nome) {
        String termoBusca = "%" + nome + "%";
        String queryStatement = "SELECT age.id as id_agendamento, pe.nome as nome_paciente, pe.data_nascimento, horario, data,me.id as id_medico, me.nome as nome_medico, me.consultorio, pe.id as id_paciente "
                + "FROM agendamento as age "
                + "JOIN medico as me ON age.id_medico=me.id "
                + "JOIN paciente as pe ON age.id_paciente=pe.id "
                + "WHERE pe.nome like ?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Agendamento> agendamentos = parseResultSetToAgendamentoConsulta(resultSet);
            preparedStatement.close();

            return agendamentos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());

            return new ArrayList<>();
        }
    }

    public List<Agendamento> getAgendamentosDoDiaByNomeEByData(String nome, Date dataAgendamento) {
        String termoBusca = "%" + nome + "%";
        String queryStatement = "SELECT age.id as id_agendamento, pe.nome as nome_paciente, pe.data_nascimento, horario, data, me.id as id_medico, me.nome as nome_medico, me.consultorio, pe.id as id_paciente "
                + "FROM agendamento as age "
                + "JOIN medico as me ON age.id_medico=me.id "
                + "JOIN paciente as pe ON age.id_paciente=pe.id "
                + "WHERE pe.nome like ? AND data=?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);
            preparedStatement.setString(1, termoBusca);

            java.sql.Date sqlDate = new java.sql.Date(dataAgendamento.getTime());
            preparedStatement.setDate(2, sqlDate);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Agendamento> agendamentos = parseResultSetToAgendamentoConsulta(resultSet);
            preparedStatement.close();

            return agendamentos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());

            return new ArrayList<>();
        }
    }

    public int contaAgendamentosDoPaciente(int idPaciente) {
        String queryStatement = "SELECT COUNT(*) as total FROM agendamento WHERE id_paciente=?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);

            preparedStatement.setInt(1, idPaciente);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();

            int totalAgendamentos = parseTotalAgendamento(resultSet);
            preparedStatement.close();

            return totalAgendamentos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());

            return -1;
        }
    }

    public boolean deleteAllAgendamentosPaciente(int idPaciente) {
        try {
            String deleteStatement = "DELETE FROM agendamento WHERE id_paciente=?";
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(deleteStatement);
            preparedStatement.setInt(1, idPaciente);
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error while deleting data: " + ex.toString());

            return false;
        }
        return true;
    }

    // devolve o total de agendamento depois de contar os agendamentos do paciente
    // devolve o total de agendamento depois de contar os agendamentos do médico
    private int parseTotalAgendamento(ResultSet resultSet) throws SQLException {
        int totalAgendamentos = -1;
        
        while (resultSet.next()) {
            totalAgendamentos = resultSet.getInt("total");
        }

        return totalAgendamentos;
    }

    public int contaAgendamentosDoMedico(int idMedico) {
        String queryStatement = "SELECT COUNT(*) as total FROM agendamento WHERE id_medico=?";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);

            preparedStatement.setInt(1, idMedico);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();

            int totalAgendamentos = parseTotalAgendamento(resultSet);
            preparedStatement.close();

            return totalAgendamentos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            
            return -1;
        }
    }

    public boolean deleteAllAgendamentosMedico(int idMedico) {
        try {
            String deleteStatement = "DELETE FROM agendamento WHERE id_medico=?";
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(deleteStatement);
            preparedStatement.setInt(1, idMedico);
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Error while deleting data: " + ex.toString());
            
            return false;
        }
        
        return true;
    }

    public int getCountTotalSchedules() {

        String queryStatement = "SELECT COUNT(*) as total FROM agendamento";

        try {
            PreparedStatement preparedStatement = mySQLConn.getConnection().prepareStatement(queryStatement);

            // Recupera dados da base
            ResultSet resultSet = preparedStatement.executeQuery();

            int totalAgendamentos = parseTotalAgendamento(resultSet);
            preparedStatement.close();

            return totalAgendamentos;

        } catch (Exception ex) {
            System.out.println("Error while querying data: " + ex.toString());
            
            return -1;
        }
    }
}
