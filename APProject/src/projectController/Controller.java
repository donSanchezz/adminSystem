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
import projectModel.Complaint;
import projectModel.Query;
import projectView.AgentViewCompaint;
import projectView.Login;
import projectView.StuDashboard;
import projectView.newComplaint;
import projectView.newQuery;

public class Controller {
	
	private Login login;
	private SQLOperations ops;
	private StuDashboard stuDash;
	private newComplaint newComp;
	private newQuery newQuery;
	private AgentViewCompaint agentViewC;
	
	newComplaint ncmp = new newComplaint();
	Client client = new Client();
	
	public Controller (Login login, StuDashboard stuDash, newComplaint newComp, newQuery newQuery, AgentViewCompaint agentViewC) {
		
		this.login = login;
		this.stuDash = stuDash;
		this.newComp = newComp;
		this.newQuery = newQuery;
		////this.agentViewC = agentViewC
		
		//Login listeners
		this.login.addLoginListener(new loginBtnListener());
		//Dashboard listeners
		this.stuDash.addNewComplaintListener( new NewCompListener());
		this.stuDash.addNewQueryListener( new NewQueryListener());
		//Complaint listeners
		this.newComp.addClearListenerC(new listenForClearBttnC());
		this.newComp.addExitListenerC(new listenForExitBttnC());
		this.newComp.addSubmitListenerC(new listenForSubmitBttnC());
		//Query listeners
		this.newQuery.addClearListenerQ(new listenForClearBttnQ());
		this.newQuery.addExitListenerQ(new listenForExitBttnQ());
		this.newQuery.addSubmitListenerQ(new listenForSubmitBttnQ());
		
		//agent view
		this.agentViewC.AddNewTableListener(new listenForJTable());
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
	 
	 //Dashboard Action Listeners
	 class NewCompListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 
			 newComp.setVisible(true);
			 stuDash.setVisible(false);
			
		 }
	 }
	 
	 class NewQueryListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 
			 newQuery.setVisible(true);
			 stuDash.setVisible(false);
			
		 }
	 }
	 
	
	 
	 //Complaint Action Listeners
	 class listenForClearBttnC implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			

			 newComp.stuIdTxtField.setText(" ");
			 newComp.compTxtArea.setText(" ");
			 newComp.compCmbBox.setSelectedIndex(0);
		 }
	 }
	 
	 class listenForExitBttnC implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			
			 newComp.setVisible(false);
			 stuDash.setVisible(true);
			 newComp.stuIdTxtField.setText(" ");
			 newComp.compTxtArea.setText(" ");
			 newComp.compCmbBox.setSelectedIndex(0);
		 }
	 }
	 
	 class listenForSubmitBttnC implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 client.sendAction("Add Complaint");
			 client.sendComplaint(new Complaint(0, newComp.dateTxtField.getText(), newComp.timeTxtField.getText(), newComp.compCmbBox.getSelectedItem().toString(), newComp.compTxtArea.getText(), Integer.parseInt(newComp.stuIdTxtField.getText())));
			 if (client.recieveResponse()== true) {
				 JOptionPane.showMessageDialog(null, "Complaint Logged Sucessfull"); 
				 
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Complaint Logged Unsucessfull");
			 };
			 newComp.setVisible(false);
			 stuDash.setVisible(true);
			 newComp.stuIdTxtField.setText(" ");
			 newComp.compTxtArea.setText(" ");
			 newComp.compCmbBox.setSelectedIndex(0);
		 }
	 }
	 

	 //Query Action Listeners
	 
	 class listenForClearBttnQ implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			

			 newQuery.stuIdTxtField.setText(" ");
			 newQuery.queryTxtArea.setText(" ");
			 newQuery.queryCmbBox.setSelectedIndex(0);
		 }
	 }
	 
	 class listenForExitBttnQ implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			
			 newQuery.setVisible(false);
			 stuDash.setVisible(true);
			 newQuery.stuIdTxtField.setText(" ");
			 newQuery.queryTxtArea.setText(" ");
			 newQuery.queryCmbBox.setSelectedIndex(0);
			 
		 }
	 }
	 
	 class listenForSubmitBttnQ implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 client.sendAction("Add Query");
			 client.sendQuery(new Query(0, newQuery.dateTxtField.getText(), newQuery.timeTxtField.getText(), newQuery.queryCmbBox.getSelectedItem().toString(), newQuery.queryTxtArea.getText(), Integer.parseInt(newQuery.stuIdTxtField.getText())));
			 if (client.recieveResponse()== true) {
				 JOptionPane.showMessageDialog(null, "Query Logged Sucessfull"); 
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Query Logged Unsucessfull");
			 };
			 client.sendAction("Exit");
			 newQuery.setVisible(false);
			 stuDash.setVisible(true);
			 newQuery.stuIdTxtField.setText(" ");
			 newQuery.queryTxtArea.setText(" ");
			 newQuery.queryCmbBox.setSelectedIndex(0);
		 }
	 }
	 
	
	 
	

}
