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
	            sql = "INSERT INTO consulta (cpf_paciente, cpf_funcionario, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, exames) " +
	                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        } else { 
	            sql = "UPDATE consulta SET cpf_paciente = ?, cpf_funcionario = ?, data_consulta = ?, anamnese = ?, avaliacao_vocal = ?, diagnostico = ?, conduta = ?, observacoes = ?, exames = ? WHERE id = ?";
	            stmt = conn.prepareStatement(sql);
	        }

	        stmt.setString(1, consulta.getPacienteCpf());
	        stmt.setString(2, consulta.getFuncionarioCpf());
	        stmt.setDate(3, consulta.getDataConsulta() != null ? Date.valueOf(consulta.getDataConsulta()) : null);
	        stmt.setString(4, consulta.getAnamnese());
	        stmt.setString(5, consulta.getAvaliacaoVocal());
	        stmt.setString(6, consulta.getDiagnostico());
	        stmt.setString(7, consulta.getConduta());
	        stmt.setString(8, consulta.getObservacoes());

	        if (consulta.getAnexarExames() != null) {
	            stmt.setBytes(9, consulta.getAnexarExames());
	        } else {
	            stmt.setNull(9, java.sql.Types.BLOB);
	        }

	        if (consulta.getId() == 0) {
	            stmt.executeUpdate();
	            rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                idGerado = rs.getInt(1);
	                consulta.setId(idGerado);
	            }
	        } else {
	            stmt.setInt(10, consulta.getId());
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
        String sql = "SELECT id, cpf_paciente, cpf_funcionario, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, exames FROM consulta WHERE id = ?";
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
                consulta.setPacienteCpf(rs.getString("cpf_paciente"));
                consulta.setFuncionarioCpf(rs.getString("cpf_funcionario"));
                consulta.setDataConsulta(rs.getDate("data_consulta") != null ? rs.getDate("data_consulta").toLocalDate() : null);
                consulta.setAnamnese(rs.getString("anamnese"));
                consulta.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setConduta(rs.getString("conduta"));
                consulta.setObservacoes(rs.getString("observacoes"));
                consulta.setAnexarExames(rs.getBytes("exames"));
            }
            return consulta;
        } catch (SQLException e) {
            throw new SystemException("Erro ao buscar consulta por CPF: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }
    }
    
    public List<Consulta> buscarConsultasPorNomeOuCpf(String termoBusca) throws SystemException {
        List<Consulta> consulta = new ArrayList<>();
        String sql = "SELECT c.* FROM consulta c " +
                     "JOIN pacientes p ON c.cpf_paciente = p.cpf " +
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
                Consulta consultaCpfNome = new Consulta();
                consultaCpfNome.setId(rs.getInt("id"));
                consultaCpfNome.setPacienteCpf(rs.getString("cpf_paciente"));
                consultaCpfNome.setFuncionarioCpf(rs.getString("cpf_funcionario"));
                consultaCpfNome.setDataConsulta(rs.getDate("data_consulta").toLocalDate());
                consultaCpfNome.setAnamnese(rs.getString("anamnese"));
                consultaCpfNome.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consultaCpfNome.setDiagnostico(rs.getString("diagnostico"));
                consultaCpfNome.setConduta(rs.getString("conduta"));
                consultaCpfNome.setObservacoes(rs.getString("observacoes"));
                consultaCpfNome.setAnexarExames(rs.getBytes("exames"));
                consulta.add(consultaCpfNome);
            }
        } catch (SQLException e) {
            throw new SystemException("Erro ao buscar consultas por nome ou CPF: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }

        return consulta;
    }

    public boolean deletar(int id) throws SystemException {
        String sql = "DELETE FROM consulta WHERE id = ?";
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
        List<Consulta> consulta = new ArrayList<>();
        String sql = "SELECT id, cpf_paciente, cpf_funcionario, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, exames FROM consulta";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consultaTodas = new Consulta();
                consultaTodas.setId(rs.getInt("id"));
                consultaTodas.setPacienteCpf(rs.getString("cpf_paciente"));
                consultaTodas.setFuncionarioCpf(rs.getString("cpf_funcionario"));
                consultaTodas.setDataConsulta(rs.getDate("data_consulta") != null ? rs.getDate("data_consulta").toLocalDate() : null);
                consultaTodas.setAnamnese(rs.getString("anamnese"));
                consultaTodas.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consultaTodas.setDiagnostico(rs.getString("diagnostico"));
                consultaTodas.setConduta(rs.getString("conduta"));
                consultaTodas.setObservacoes(rs.getString("observacoes"));
                consultaTodas.setAnexarExames(rs.getBytes("exames"));
                consulta.add(consultaTodas);
            }
        } catch (SQLException e) {
            throw new SystemException("Erro ao listar consultas: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }
        return consulta;
    }

    public List<Consulta> listarConsultasPorPaciente(String pacienteCpf) throws SystemException {
        List<Consulta> consulta = new ArrayList<>();
        String sql = "SELECT id, cpf_paciente, cpf_funcionario, data_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes, exames FROM consulta WHERE cpf_paciente = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pacienteCpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consultaPaciente = new Consulta();
                consultaPaciente.setId(rs.getInt("id"));
                consultaPaciente.setPacienteCpf(rs.getString("cpf_paciente"));
                consultaPaciente.setFuncionarioCpf(rs.getString("cpf_funcionario"));
                consultaPaciente.setDataConsulta(rs.getDate("data_consulta") != null ? rs.getDate("data_consulta").toLocalDate() : null);
                consultaPaciente.setAnamnese(rs.getString("anamnese"));
                consultaPaciente.setAvaliacaoVocal(rs.getString("avaliacao_vocal"));
                consultaPaciente.setDiagnostico(rs.getString("diagnostico"));
                consultaPaciente.setConduta(rs.getString("conduta"));
                consultaPaciente.setObservacoes(rs.getString("observacoes"));
                consultaPaciente.setAnexarExames(rs.getBytes("exames"));
                consulta.add(consultaPaciente);
            }
        } catch (SQLException e) {
            throw new SystemException("Erro ao listar consultas por paciente: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(conn, stmt);
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { }
            }
        }
        return consulta;
    }
}
