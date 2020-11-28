package factory;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import configuration.Server;

public class dbConnector {
	
	private static final Logger Logger = LogManager.getLogger(Server.class);
	
	public static Connection getConnection () {

	//Create a JDBC:MySQL URL to the database to be queried
			String jdbcUrl = "jdbc:mysql://localhost:3306/adminsystem";
			String username = "root"; //User name & Password for database connection
			String password = "madthing123";
			
			Connection dbConn = null; //Create a JDBC Connection object
			
	
			try {
				Logger.warn("Attempting to connect to localhost");
				//Try to get a connection to the MySQL server and database
				Logger.warn("Attempting to connect to: " +jdbcUrl);
				dbConn = DriverManager.getConnection(jdbcUrl, username, password);
				
				if (dbConn != null) { //Check if the connection was successful
					Logger.info("Connection to database server succesful");
	
				}
			}catch(SQLException e) {
			Logger.error("Error connecting to database, check your username or password");
			
		}
			return dbConn;
	}
}
