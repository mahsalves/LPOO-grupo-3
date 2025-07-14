package br.com.otorrinofono.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/interface_otorrino_fono";
	public static final String USER = "root";
	public static final String PASS = "83627438Jp*";
	
	public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }


}
