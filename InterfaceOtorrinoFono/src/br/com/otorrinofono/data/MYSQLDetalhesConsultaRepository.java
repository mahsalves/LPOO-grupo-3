package br.com.otorrinofono.data;

import java.sql.*;
import br.com.otorrinofono.entities.DetalhesConsulta;
import br.com.otorrinofono.exception.SystemException;

public class MySQLDetalhesConsultaRepository implements DetalhesConsultaRepository {

    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sistema_otorrino_fono", "root", "12457836");
    }

    @Override
    public void salvar(DetalhesConsulta detalhes) {
        try (Connection conn = connect()) {
            String sql = "INSERT INTO detalhes_consulta (id_consulta, anamnese, avaliacao_vocal, diagnostico, conduta, observacoes) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, detalhes.getIdConsulta());
            stmt.setString(2, detalhes.getAnamnese());
            stmt.setString(3, detalhes.getAvaliacaoVocal());
            stmt.setString(4, detalhes.getDiagnostico());
            stmt.setString(5, detalhes.getConduta());
            stmt.setString(6, detalhes.getObservacoes());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new SystemException("Erro ao salvar detalhes da consulta.", e);
        }
    }

    @Override
    public DetalhesConsulta buscarPorConsulta(int idConsulta) {
        try (Connection conn = connect()) {
            String sql = "SELECT * FROM detalhes_consulta WHERE id_consulta = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idConsulta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DetalhesConsulta(
                    rs.getInt("id_detalhe"),
                    rs.getInt("id_consulta"),
                    rs.getString("anamnese"),
                    rs.getString("avaliacao_vocal"),
                    rs.getString("diagnostico"),
                    rs.getString("conduta"),
                    rs.getString("observacoes")
                );
            }
            return null;
        } catch (Exception e) {
            throw new SystemException("Erro ao buscar detalhes da consulta.", e);
        }
    }

    @Override
    public void atualizar(DetalhesConsulta detalhes) {
        try (Connection conn = connect()) {
            String sql = "UPDATE detalhes_consulta SET anamnese = ?, avaliacao_vocal = ?, diagnostico = ?, conduta = ?, observacoes = ? WHERE id_consulta = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, detalhes.getAnamnese());
            stmt.setString(2, detalhes.getAvaliacaoVocal());
            stmt.setString(3, detalhes.getDiagnostico());
            stmt.setString(4, detalhes.getConduta());
            stmt.setString(5, detalhes.getObservacoes());
            stmt.setInt(6, detalhes.getIdConsulta());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new SystemException("Erro ao atualizar detalhes da consulta.", e);
        }
    }

    @Override
    public void deletar(int idDetalhe) {
        try (Connection conn = connect()) {
            String sql = "DELETE FROM detalhes_consulta WHERE id_detalhe = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idDetalhe);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new SystemException("Erro ao deletar detalhes da consulta.", e);
        }
    }
}
