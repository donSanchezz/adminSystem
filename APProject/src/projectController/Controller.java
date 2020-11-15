package projectController;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import jdbc.connection.SQLOperations;
import jdbc.connection.dbConnector;
import projectView.Login;
import projectView.StuDashboard;

public class Controller {
	
	private Login login;
	private SQLOperations ops;
	private StuDashboard stuDash;
	

	
	public Controller (Login login, StuDashboard stuDash) {
		
		this.login = login;
		this.stuDash = stuDash;
		
		this.login.addLoginListener(new loginBtnListener());
		this.stuDash.addNewComplaintListener( new NewCompListener());
	}
	
	
	//Where the log-in button get's handled.
	 class loginBtnListener implements ActionListener {

	
		public void actionPerformed(ActionEvent e) {
			
			
			//getting a connection
			Connection con = dbConnector.getConnection();
			//A query statement that gets the user input for username and view from the Login(View).
			try {
				Statement stmt = con.createStatement();
				String loginSql = "Select * from login where username = '"+login.user.getText()+ "' and password = '"+login.pass.getText().toString()+"'";
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
			

		}
		 
	 }
	 
	 
	 class NewCompListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {

			
		 }
	 }

}
