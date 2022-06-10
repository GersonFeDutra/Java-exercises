package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String USERNAME = "root"; // user MySQL
	private static final String PASSWORD = ""; // database pass
	// database path/ door/ name
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	// 3306 is the default door to MySQL and MariaDB

	/*
	 * DataBase connection
	 */
	public static Connection createMySQLConnection() throws ClassNotFoundException, SQLException {
		// Makes JVM to load the driver class
		Class.forName("com.mysql.jdbc.Driver");
		// Makes database connection
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Recover database connection
		Connection connection = createMySQLConnection();

		if (connection != null) {
			System.out.println("Connection obtained!");
			connection.close();
		}
	}

}
