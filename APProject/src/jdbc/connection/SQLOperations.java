package jdbc.connection;


import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import factory.dbConnector;
import projectModel.Complaint;
import projectModel.Student;
import projectView.Login;

public class SQLOperations {
	private Connection dbConn = null;
	private Statement stmt = null;
	private int numOfAffectedRows = 0;
	private Student student;
	 private Login theView;
	
	public SQLOperations ( Connection dbConn) {
		this.dbConn =  dbConn;

	}

	
	
	/*
	public void logInBtn() {
		try {
			Statement stmt = dbConn.createStatement();
			String loginSql = "Select * from login where username = '"+theView.user.getText()+ "' and password = '"+theView.pass.getText().toString()+"'";
			ResultSet rs = stmt.executeQuery(loginSql);
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Login Sucessfull");
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect username and password...");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}*/
	
	/*public boolean insertStudent (Student s) {
		
	String insertSql = "INSERT INTO `students`"
			+ "(`stuId`, `firstName`, `lastName`, `email`, `cantNum`, `typeIssue`, `detailIssue`)"
			+"VALUES (' " +s.getStuId()+ " ', ' "+s.getFirstName()+ " ' , ' "+s.getLastName()+" ', ' " +s.getEmail()+" ' , ' " +s.getCantactNum()+"')";
	
	
		try {
			stmt = dbConn.createStatement();
			numOfAffectedRows = stmt.executeUpdate(insertSql);
			return (numOfAffectedRows ==1);
			
		
	}catch (SQLException e) {
		System.out.println("SQL Exception Thrown: " +e.getMessage());
	}
		return false;*/
	
	public ArrayList<Complaint> cmpList () {
		ArrayList<Complaint> cmpList = new ArrayList<Complaint>();
		dbConnector con1;
		Connection con = dbConnector.getConnection();
		String query = "SELECT * FROM `complaint`";
		Statement st;
		ResultSet rs;
		
		try {
			st = (Statement) con.createStatement();
			rs = st.executeQuery(query);
			Complaint cmp;
			while(rs.next()) {
				cmp = new Complaint (rs.getInt("id"), rs.getString("date"), rs.getString("time"), rs.getString("typeOfComplaint"), rs.getString("complaint"), rs.getInt("stuId"));
				cmpList.add(cmp);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return cmpList;
		
	}
	
	
}
	
	
	
	





