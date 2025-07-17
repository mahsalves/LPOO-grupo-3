package br.com.otorrinofono.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/interface_otorrino_fono";
	public static final String USER = "root";
	public static final String PASS = "12Mar34ce56la";
	
	public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

	public static void closeConnection(Connection conn, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar PreparedStatement:");
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão:");
                e.printStackTrace();
            }
        }
    }
	
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar ResultSet:");
                e.printStackTrace();
            }
        }

        closeConnection(conn, stmt);
    }
}