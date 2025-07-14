package br.com.otorrinofono.data;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.otorrinofono.entities.Paciente;
import br.com.otorrinofono.util.DatabaseConnection;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

public class PacienteRepository {
	public void salvar(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, cpf, email, telefone, cidade, endereco, cep, prontuario, genero, estado, data_nasc) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefone());
            stmt.setString(5, paciente.getCidade());
            stmt.setString(6, paciente.getEndereco());
            stmt.setString(7, paciente.getCep());
            stmt.setString(8, paciente.getNumeroProntuario());
            stmt.setString(9, paciente.getGenero());
            stmt.setString(10, paciente.getEstado());

            if (paciente.getDataNascimento() != null) {
                stmt.setDate(11, java.sql.Date.valueOf(paciente.getDataNascimento()));
            } else {
                stmt.setDate(11, null);
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao salvar paciente: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar paciente no banco de dados", e);
        }
    }
	
	
	public void atualizar(Paciente paciente) throws SQLException {
	    String sql = "UPDATE paciente SET nome = ?, data_nasc = ?, genero = ?, estado = ?, " +
	                 "prontuario = ?, email = ?, telefone = ?, cep = ? WHERE cpf = ?";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, paciente.getNome());
	        stmt.setDate(2, java.sql.Date.valueOf(paciente.getDataNascimento()));
	        stmt.setString(3, paciente.getGenero());
	        stmt.setString(4, paciente.getEstado());
	        stmt.setString(5, paciente.getNumeroProntuario());
	        stmt.setString(6, paciente.getEmail());
	        stmt.setString(7, paciente.getTelefone());
	        stmt.setString(8, paciente.getCep());
	        stmt.setString(9, paciente.getCpf());

	        int rowsUpdated = stmt.executeUpdate();
	        if (rowsUpdated == 0) {
	            throw new SQLException("Nenhum paciente encontrado com o CPF informado para atualização.");
	        }
	    }
	}
	
	
	public List<Paciente> listarTodos() {
	    List<Paciente> pacientes = new ArrayList<>();
	    String sql = "SELECT * FROM paciente";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Paciente paciente = new Paciente();
	            paciente.setNome(rs.getString("nome"));
	            paciente.setCpf(rs.getString("cpf"));
	            paciente.setEmail(rs.getString("email"));
	            paciente.setTelefone(rs.getString("telefone"));
	            paciente.setCidade(rs.getString("cidade"));
	            paciente.setEndereco(rs.getString("endereco"));
	            paciente.setCep(rs.getString("cep"));
	            paciente.setNumeroProntuario(rs.getString("numero_prontuario"));
	            paciente.setGenero(rs.getString("genero"));
	            paciente.setEstado(rs.getString("estado"));
	            if (rs.getDate("data_nascimento") != null) {
	                paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
	            }
	            pacientes.add(paciente);
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao listar pacientes", e);
	    }

	    return pacientes;
	}

    public boolean existePorCpf(String cpf) {
        String sql = "SELECT COUNT(*) FROM paciente WHERE cpf = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

            return false;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar CPF no banco de dados", e);
        }
    }

    public Paciente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM paciente WHERE cpf = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setCidade(rs.getString("cidade"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setCep(rs.getString("cep"));
                paciente.setNumeroProntuario(rs.getString("numero_prontuario"));
                paciente.setGenero(rs.getString("genero"));
                paciente.setEstado(rs.getString("estado"));
                if (rs.getDate("data_nascimento") != null) {
                    paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                }
                return paciente;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar paciente por CPF", e);
        }

        return null;
    }

    public void removerPorCpf(String cpf) {
        String sql = "DELETE FROM paciente WHERE cpf = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover paciente por CPF", e);
        }
    }
}