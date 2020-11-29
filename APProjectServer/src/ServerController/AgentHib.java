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
import projectModel.Agent;


public class AgentHib {
	private static final Logger Logger = LogManager.getLogger(Server.class);
	public Boolean agentLogin (String username, String password) {
		Boolean flag = null;
	//getting a connection
	Logger.warn("Attempting to set-up a connection");
	Connection con = dbConnector.getConnection();
	Logger.info("Connecting successfull");
	//A query statement that gets the user input for username and view from the Login(View).
	try {
		Logger.warn("Attempting to create a statement from the connection");
		Statement stmt = con.createStatement();
		String loginSql = "Select * from agents where id = '"+username+ "' and pass = '"+password+"'";
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
	
	
	public ArrayList<Agent> getAgentInfo(String ID) {
		
		ArrayList<Agent> agentInfo = new ArrayList<>();
		
		//getting a connection
		Logger.warn("Attempting to set-up a connection");
		Connection con = dbConnector.getConnection();
		Logger.info("Connecting successfull");
		//A query statement that gets the user input for username and view from the Login(View).
		try {
			Logger.warn("Attempting to create a statement from the connection");
			Statement stmt = con.createStatement();
			String loginSql = "Select * from agents where id = '"+ID+"'";
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
				
				Agent agt = new Agent();
				agt.setStuId(id);
				agt.setFirstName(firstName);
				agt.setLastName(lastName);
				agt.setEmail(email);
				agt.setCantNum(contactNum);
				agt.setPass(pass);
				
				agentInfo.add(agt);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return agentInfo;
	}
	
	public Boolean agentUpdateComp (String ID, String status) {
		Boolean flag = null;
	//getting a connection
	Logger.warn("Attempting to set-up a connection");
	Connection con = dbConnector.getConnection();
	Logger.info("Connecting successfull");
	//A query statement that gets the user input for username and view from the Login(View).
	try {
		Logger.warn("Attempting to create a statement from the connection");
		Statement stmt = con.createStatement();
		String sql = "Update complaint set status = '"+status+ "' where id = '"+ID+"'";
		Logger.info("Statement created and stored:" +sql);
		ResultSet rs = stmt.executeQuery(sql);
		Logger.warn("Attempting to update database table");
		if (rs.next()) {
			Logger.info("Update successfull!");
			flag = true;
		}
		else {
			Logger.info("Update failed!");
			flag = false;
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	return flag;
	}
}
