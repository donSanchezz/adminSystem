package projectController;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jdbc.connection.SQLOperations;
import jdbc.connection.dbConnector;
import projectModel.Complaint;
import projectModel.Query;
import projectView.AgentDashboard;
import projectView.AgentViewCompaint;
import projectView.AgentViewComplaintAdm;
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
	private AgentDashboard agentDash;
	private AgentViewCompaint agentViewComp;
	private AgentViewComplaintAdm agentViewCompAdm;
	
	newComplaint ncmp = new newComplaint();
	Client client = new Client();
	
	public Controller (Login login, StuDashboard stuDash, newComplaint newComp, newQuery newQuery, AgentDashboard agentDash, AgentViewCompaint agentViewComp, AgentViewComplaintAdm agentViewCompAdm) {
		
		this.login = login;
		this.stuDash = stuDash;
		this.newComp = newComp;
		this.newQuery = newQuery;
		this.agentDash = agentDash;
		this.agentViewComp = agentViewComp;
		this.agentViewCompAdm = agentViewCompAdm;
		
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
		//this.agentViewC.AddNewTableListener(new listenForJTable());
		
		//agent dashboard
		this.agentDash.addViewCompListener(new listenForViewCompMenuBttn());
		this.agentDash.addViewCompListenerAdm(new listenForViewCompAdmMenuBttn());
		
		
		//agent financial view 
		this.agentViewComp.addUpdateListener(new listenForUpdateBttn());
		this.agentViewComp.addJTableListener( new listenForJTableClicked());
		
		//agent administration view
		this.agentViewCompAdm.addUpdateListener( new listenForUpdateAdmBttn());
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
	 
	 
	 class listenForViewCompMenuBttn implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			agentViewComp.setVisible(true);
		}
		 
		 
	 }
	 
	 class listenForViewCompAdmMenuBttn implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				
				agentViewCompAdm.setVisible(true);
			}
			 
			 
		 }
	
	 class listenForUpdateBttn implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			ArrayList<Complaint> list = new ArrayList<Complaint>();
			client.sendAction("View Complaint Financial");
			try {
				list =  client.recieveComplaintsFinancial();
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//System.out.println(list.get(0));
			//System.out.println(list.get(1));
			//System.out.println(list.get(2));
			
			//Adding each item in the ArrayList to a row
			DefaultTableModel model = (DefaultTableModel) agentViewComp.table.getModel();
			Object [] row = new Object [6];
			for (int i = 0; i<list.size(); i++) {
				row[0] = list.get(i).getId();
				row[1] = list.get(i).getDate();
				row[2]= list.get(i).getTime();
				row[3]= list.get(i).getTypeOfComplaint();
				row[4]=list.get(i).getComplaint();
				row[5]=list.get(i).getStuId();
				model.addRow(row);
			}
		}
		 
	 }
	 
	 class listenForJTableClicked implements MouseListener {
		 public void mouseClicked(MouseEvent arg0) {
			 int i = agentViewComp.table.getSelectedRow();
			 TableModel model = agentViewComp.table.getModel();
			 agentViewCompAdm.cmpIdTxt.setText(model.getValueAt(i, 0).toString());
			 agentViewCompAdm.dateTxt.setText(model.getValueAt(i, 1).toString());
			 agentViewCompAdm.timeTxt.setText(model.getValueAt(i, 2).toString());
			 agentViewCompAdm.typeTxt.setText(model.getValueAt(i, 3).toString());
			 agentViewCompAdm.stuIdTxt.setText(model.getValueAt(i, 5).toString());
			 agentViewCompAdm.textArea.setText(model.getValueAt(i, 4).toString());

			}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {	
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	 }
	 
	 
	 class listenForUpdateAdmBttn implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				ArrayList<Complaint> list = new ArrayList<Complaint>();
				client.sendAction("View Complaint Admin");
				try {
					list =  client.recieveComplaintsAdmin();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println(list.get(0));
				//System.out.println(list.get(1));
				//System.out.println(list.get(2));
				
				//Adding each item in the ArrayList to a row
				DefaultTableModel model = (DefaultTableModel) agentViewCompAdm.table.getModel();
				Object [] row = new Object [6];
				for (int i = 0; i<list.size(); i++) {
					row[0] = list.get(i).getId();
					row[1] = list.get(i).getDate();
					row[2]= list.get(i).getTime();
					row[3]= list.get(i).getTypeOfComplaint();
					row[4]=list.get(i).getComplaint();
					row[5]=list.get(i).getStuId();
					model.addRow(row);
				}
			}
			 
		 }
	 
	

}
