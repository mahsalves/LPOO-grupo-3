package br.com.otorrinofono.data;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.otorrinofono.entities.Consulta;
import br.com.otorrinofono.exception.SystemException;
import br.com.otorrinofono.util.DatabaseConnection;

public class ConsultaRepository {

    public int salvar(Consulta consulta) throws SystemException {
        String sql;
        int idGerado = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();

            if (consulta.getId() == 0) { 
                sql = "INSERT INTO consultas (paciente_id, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, anexar_exames) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            } else { 
                sql = "UPDATE consultas SET paciente_id = ?, data_consulta = ?, anamnese = ?, avaliacao_vocal = ?, diagnostico = ?, conduta = ?, observacoes = ?, anexar_exames = ? WHERE id = ?";
                stmt = conn.prepareStatement(sql);
            }

            //stmt.setInt(1, consulta.getPacienteId());
            stmt.setString(1, consulta.getPacienteCpf());
            stmt.setDate(2, consulta.getDataConsulta() != null ? Date.valueOf(consulta.getDataConsulta()) : null);
            stmt.setString(3, consulta.getAnamnese());
            stmt.setString(4, consulta.getAvaliacaoVocal());
            stmt.setString(5, consulta.getDiagnostico());
            stmt.setString(6, consulta.getConduta());
            stmt.setString(7, consulta.getObservacoes());

            if (consulta.getAnexarExames() != null) {
                stmt.setBytes(8, consulta.getAnexarExames());
            } else {
                stmt.setNull(8, java.sql.Types.BLOB);
            }
            

            if (consulta.getId() == 0) {
                stmt.executeUpdate();
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    idGerado = rs.getInt(1);
                    consulta.setId(idGerado);
                }
            } else {
                stmt.setInt(9, consulta.getId());
                stmt.executeUpdate();
                idGerado = consulta.getId();
            }
        } catch (SQLException e) {
        	
            throw new SystemException("Erro ao salvar consulta: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }
        return idGerado;
    }

    public Consulta buscarPorId(int id) throws SystemException {
        String sql = "SELECT id, paciente_id, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, anexar_exames FROM consultas WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Consulta consulta = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setPacienteId(rs.getInt("paciente_id"));
                consulta.setDataConsulta(rs.getDate("data_consulta") != null ? rs.getDate("data_consulta").toLocalDate() : null);
                consulta.setAnamnese(rs.getString("anamnese"));
                consulta.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setConduta(rs.getString("conduta"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setAnexarExames(rs.getBytes("anexar_exames"));
            }
            return consulta;
        } catch (SQLException e) {
            throw new SystemException("Erro ao buscar consulta por ID: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }
    }
    
    public List<Consulta> buscarConsultasPorNomeOuCpf(String termoBusca) throws SystemException {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT c.* FROM consultas c " +
                     "JOIN pacientes p ON c.paciente_id = p.id " +
                     "WHERE p.nome LIKE ? OR p.cpf LIKE ?";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            String termo = "%" + termoBusca + "%";
            stmt.setString(1, termo);
            stmt.setString(2, termo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setPacienteId(rs.getInt("paciente_id"));
                consulta.setDataConsulta(rs.getDate("data_consulta").toLocalDate());
                consulta.setAnamnese(rs.getString("anamnese"));
                consulta.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setConduta(rs.getString("conduta"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setAnexarExames(rs.getBytes("anexar_exames"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            throw new SystemException("Erro ao buscar consultas por nome ou CPF: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* ignorar */ }
            }
        }

        return consultas;
    }

    public boolean deletar(int id) throws SystemException {
        String sql = "DELETE FROM consultas WHERE id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new SystemException("Erro ao deletar consulta: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
        }
    }

    public List<Consulta> listarTodasConsultas() throws SystemException {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT id, paciente_id, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, anexar_exames FROM consultas";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setPacienteId(rs.getInt("paciente_id"));
                consulta.setDataConsulta(rs.getDate("data_consulta") != null ? rs.getDate("data_consulta").toLocalDate() : null);
                consulta.setAnamnese(rs.getString("anamnese"));
                consulta.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setConduta(rs.getString("conduta"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setAnexarExames(rs.getBytes("anexar_exames"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            throw new SystemException("Erro ao listar consultas: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }
        return consultas;
    }

    public List<Consulta> listarConsultasPorPaciente(int pacienteId) throws SystemException {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT id, paciente_id, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, anexar_exames FROM consultas WHERE paciente_id = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pacienteId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id"));
                consulta.setPacienteId(rs.getInt("paciente_id"));
                consulta.setDataConsulta(rs.getDate("data_consulta") != null ? rs.getDate("data_consulta").toLocalDate() : null);
                consulta.setAnamnese(rs.getString("anamnese"));
                consulta.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setConduta(rs.getString("conduta"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setAnexarExames(rs.getBytes("anexar_exames"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            throw new SystemException("Erro ao listar consultas por paciente: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }
        return consultas;
    }
}
