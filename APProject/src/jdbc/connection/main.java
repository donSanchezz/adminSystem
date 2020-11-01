package jdbc.connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {

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
				
		
		
		Student student = new Student (1, "John", "Mark", "johnmark@gmail.com", 1114444, "Financial", "I cant pay tomorrow");
		
		
		
		SQLOperations sql = new SQLOperations (dbConn);
		
		
		boolean created = sql.insertStudent(student);
		if (created==true) {
			JOptionPane.showMessageDialog(null,  "Contact created", "Contact Creation", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
