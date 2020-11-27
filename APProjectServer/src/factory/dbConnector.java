package factory;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class dbConnector {
	
	public static Connection getConnection () {

	//Create a JDBC:MySQL URL to the database to be queried
			String jdbcUrl = "jdbc:mysql://localhost:3306/adminsystem";
			String username = "root"; //User name & Password for database connection
			String password = "madthing123";
			
			Connection dbConn = null; //Create a JDBC Connection object
			
			System.out.println("Connecting to localhost");
			try {
				//Try to get a connection to the MySQL server and database
				System.out.println("Attempting to connect to: " +jdbcUrl);
				dbConn = DriverManager.getConnection(jdbcUrl, username, password);
				
				if (dbConn != null) { //Check if the connection was successful
					JOptionPane.showMessageDialog(null, 
							"Connection to database server succesful", 
							"DB Connection Status", JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(SQLException e) {
			System.out.println("Error connecting to database, check your username or password");
			
		}
			return dbConn;
	}
}
