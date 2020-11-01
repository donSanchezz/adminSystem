package jdbc.connection;


import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;

public class SQLOperations {
	private Connection dbConn = null;
	private Statement stmt = null;
	private int numOfAffectedRows = 0;
	private Student student;
	
	public SQLOperations (Connection dbConn) {
		this.dbConn =  dbConn;
	}

	
	public boolean insertStudent (Student s) {
		
	String insertSql = "INSERT INTO `students`"
			+ "(`stuId`, `firstName`, `lastName`, `email`, `cantNum`, `typeIssue`, `detailIssue`)"
			+"VALUES (' " +s.getStuId()+ " ', ' "+s.getFirstName()+ " ' , ' "+s.getLastName()+" ', ' " +s.getEmail()+" ' , ' " +s.getCantNum()+" ', ' "+s.getTypeIssue()+ " ', ' " +s.getDetailIssue()+"')";
	
	
		try {
			stmt = dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSql);
			return (numOfAffectedRows ==1);
			
		
	}catch (SQLException e) {
		System.out.println("SQL Exception Thrown: " +e.getMessage());
	}
		return false;
	
	
}



}

