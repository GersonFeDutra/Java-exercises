package br.com.edu.ufca.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/* DataBase connection */
	public static Connection createMySQLConnection(String dbName) throws ClassNotFoundException, SQLException {
		// path to local database
		final String DATABASE_URL = String.format("jdbc:sqlite:db/%s.db", dbName);

		// Makes JVM to load the driver class
		Class.forName("org.sqlite.JDBC");
		// Makes database connection
		Connection connection = DriverManager.getConnection(DATABASE_URL);

		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Recover database connection
		Connection connection = createMySQLConnection("agenda");

		if (connection != null) {
			System.out.println("Connection obtained!");
			connection.close();
		}
	}

}
