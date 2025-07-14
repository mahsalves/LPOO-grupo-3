package br.com.otorrinofono.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.otorrinofono.entities.Funcionario;
import br.com.otorrinofono.exception.SystemException;
import br.com.otorrinofono.util.DatabaseConnection;

//import java.sql.DriverManager;

public class FuncionarioRepository {
	public Funcionario autenticar(String cpf, String senha) {
        
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DatabaseConnection.getConnection();
            

            String sql = "SELECT * FROM funcionario WHERE cpf = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setDataNascimento(rs.getDate("data_nasc").toLocalDate());
                funcionario.setGenero(rs.getString("genero"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setCrmCrf(rs.getString("num_registro"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setAdministrador(rs.getBoolean("administrador"));
                return funcionario;
            }

            return null;

        } catch (Exception e) {
            throw new SystemException("Erro ao autenticar funcionário", e);
        }
    }
    
    public void salvar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (cpf, nome, email, senha, data_nasc, genero, funcao, num_registro, telefone, administrador) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getSenha());
            stmt.setDate(5, java.sql.Date.valueOf(funcionario.getDataNascimento()));
            stmt.setString(6, funcionario.getGenero());
            stmt.setString(7, funcionario.getFuncao());
            stmt.setString(8, funcionario.getCrmCrf()); 
            stmt.setString(9, funcionario.getTelefone());
            stmt.setBoolean(10, funcionario.isAdministrador());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new SystemException("Erro ao salvar funcionário", e);
        }
    }
    
    public boolean existsCpf(String cpf) {
        String sql = "SELECT COUNT(*) FROM funcionario WHERE cpf = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            return false;
        } catch (SQLException e) {
            throw new SystemException("Erro ao verificar CPF", e);
        }
    }
}