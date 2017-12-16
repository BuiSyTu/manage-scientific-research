package project.control;

import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseConnection{

	// Create a variable for the connection string.
	String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=QuanLyDeTai1;integratedSecurity=True";

	// Declare the JDBC objects.
	private Connection connection;

	public DatabaseConnection() {
		connect();
	}

	public void connect() {
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			setConnection(DriverManager.getConnection(connectionUrl));
			System.out.println("connected");
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}