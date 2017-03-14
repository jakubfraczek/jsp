package pl.sda.DAO;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonSQLiteConnectionMenager {

	public PersonSQLiteConnectionMenager() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
	}

	public Connection getConnection() throws SQLException {
		String dbURL = "jdbc:sqlite:" + Paths.get(System.getProperty("user.home"), "Desktop", "museum.db");
		Connection conn = DriverManager.getConnection(dbURL);
		return conn;
	}

}
