package ServerController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import configuration.Server;
import factory.dbConnector;
import projectModel.Reps;


public class RepsHib {
	private static final Logger Logger = LogManager.getLogger(Server.class);
	
	public Boolean repsLogin (String username, String password) {
		Boolean flag = null;
	//getting a connection
	Logger.warn("Attempting to set-up a connection");
	Connection con = dbConnector.getConnection();
	Logger.info("Connecting successfull");
	//A query statement that gets the user input for username and view from the Login(View).
	try {
		Logger.warn("Attempting to create a statement from the connection");
		Statement stmt = con.createStatement();
		String loginSql = "Select * from reps where id = '"+username+ "' and pass = '"+password+"'";
		Logger.info("Statement created and stored:" +loginSql);
		ResultSet rs = stmt.executeQuery(loginSql);
		Logger.warn("Attempting to verify user's credentials");
		if (rs.next()) {
			Logger.info("User's credentials are a match!");
			flag = true;
		}
		else {
			Logger.info("User's credentials are a not match!");
			flag = false;
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	return flag;
	}
	
	
	public ArrayList<Reps> getRepInfo(String ID) {
		
		ArrayList<Reps> repsInfo = new ArrayList<>();
		
		//getting a connection
		Logger.warn("Attempting to set-up a connection");
		Connection con = dbConnector.getConnection();
		Logger.info("Connecting successfull");
		//A query statement that gets the user input for username and view from the Login(View).
		try {
			Logger.warn("Attempting to create a statement from the connection");
			Statement stmt = con.createStatement();
			String loginSql = "Select * from reps where id = '"+ID+"'";
			Logger.info("Statement created and stored:" +loginSql);
			ResultSet rs = stmt.executeQuery(loginSql);
			Logger.warn("Attempting to assign user's information");
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				int contactNum = rs.getInt("contactNum");
				String pass = rs.getString("pass");
				
				Reps rep = new Reps();
				rep.setStuId(id);
				rep.setFirstName(firstName);
				rep.setLastName(lastName);
				rep.setEmail(email);
				rep.setCantNum(contactNum);
				rep.setPass(pass);
				
				repsInfo.add(rep);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return repsInfo;
	}
}
