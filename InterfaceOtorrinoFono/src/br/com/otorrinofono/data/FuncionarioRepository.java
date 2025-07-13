package br.com.otorrinofono.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.otorrinofono.entities.Funcionario;
import br.com.otorrinofono.exception.SystemException;
import br.com.otorrinofono.util.DatabaseConnection;

import java.sql.DriverManager;

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
                funcionario.setDataNasc(rs.getString("data_nasc"));
                funcionario.setGenero(rs.getString("genero"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setNumRegistro(rs.getString("num_registro"));
                funcionario.setAdministrador(rs.getBoolean("administrador"));
                return funcionario;
            }

            return null;

        } catch (Exception e) {
            throw new SystemException("Erro ao autenticar funcionário", e);
        }
    }
}