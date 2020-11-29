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
import projectModel.Agent;
import projectModel.Complaint;
import projectModel.Query;
import projectModel.Reps;
import projectModel.Student;
import projectView.AgentDashboard;
import projectView.AgentViewCompaint;
import projectView.AgentViewComplaintAdm;
import projectView.AgentViewComplaintHlth;
import projectView.Login;
import projectView.RepDashboard;
import projectView.StuDashboard;
import projectView.newComplaint;
import projectView.newQuery;

public class Controller {
	
	private Login login;
	private SQLOperations ops;
	private StuDashboard stuDash;
	private RepDashboard repDash;
	private newComplaint newComp;
	private newQuery newQuery;
	private AgentDashboard agentDash;
	private AgentViewCompaint agentViewComp;
	private AgentViewComplaintAdm agentViewCompAdm;
	private AgentViewComplaintHlth agentViewCompHlth;
	
	newComplaint ncmp = new newComplaint();
	Client client = new Client();
	
	public Controller (Login login, StuDashboard stuDash, RepDashboard repDash, newComplaint newComp, newQuery newQuery, AgentDashboard agentDash, AgentViewCompaint agentViewComp, AgentViewComplaintAdm agentViewCompAdm, AgentViewComplaintHlth agentViewCompHlth) {
		
		this.login = login;
		this.stuDash = stuDash;
		this.newComp = newComp;
		this.newQuery = newQuery;
		this.agentDash = agentDash;
		this.agentViewComp = agentViewComp;
		this.agentViewCompAdm = agentViewCompAdm;
		this.agentViewCompHlth = agentViewCompHlth;
		this.repDash = repDash;
		
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
		this.agentDash.addViewCompListenerHlth(new listenForViewCompHlthMenuBttn());
		
		
		//agent financial view 
		this.agentViewComp.addUpdateListener(new listenForUpdateBttn());
		this.agentViewComp.addJTableListener( new listenForJTableClicked());
		
		//agent administration view
		this.agentViewCompAdm.addUpdateListener( new listenForUpdateAdmBttn());
		this.agentViewCompAdm.addJTableListener( new listenForJTableClickedAdm());
		
		//agent health view
		this.agentViewCompHlth.addUpdateListener( new listenForUpdateHlthBttn());
		this.agentViewCompHlth.addJTableListener( new listenForJTableClickedHlth());
	}
	
	
	 class loginBtnListener implements ActionListener {

		 Boolean flag;
			public void actionPerformed(ActionEvent e) {
					String action = login.comboBox.getSelectedItem().toString();
					client.sendAction(action);
					client.sendLoginInfoStu (login.user.getText(), login.pass.getText().toString());
					switch (action) {
					case "Student":
					flag = client.recieveResponse();
					try {
					if (flag==true) {
						client.sendAction("Get Student Info");
						client.sendAction(login.user.getText());
						try {
							ArrayList<Student> list = new ArrayList<Student>();
							ArrayList<Complaint> solved = new ArrayList<Complaint>();
							ArrayList<Complaint> unsolved = new ArrayList<Complaint>();
							list = client.recieveStudent();
							solved = client.recieveStuCmps();
							unsolved = client.recieveStuCmps();
							list.get(0).getStuId();
							stuDash.stuLNameHeader.setText(list.get(0).getFirstName()); 
							stuDash.stuFNameHeader.setText(list.get(0).getLastName());
							newComp.stuIdTxtField.setText(login.user.getText());
							stuDash.finUnsolvedTxt.setText(String.valueOf(solved.size()));
							stuDash.finSolvedTxt.setText(String.valueOf(unsolved.size()));
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Login Sucessfull");
						stuDash.setVisible(true);
						login.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect username and password...");
					}
			}catch(IndexOutOfBoundsException ex) {
				System.out.println("Error occured" + ex.getMessage());
				ex.printStackTrace();
			}
					break;
					case "Agent" :
						flag = client.recieveResponse();
						try {
						if (flag==true) {
							client.sendAction("Get Agent Info");
							client.sendAction(login.user.getText());
							try {
								ArrayList<Agent> agtList = new ArrayList<Agent>();
								
								agtList = client.recieveAgent();
								agtList.get(0).getStuId();
								agentDash.agtLNameHeader.setText(agtList.get(0).getFirstName()); 
								agentDash.agtFNameHeader.setText(agtList.get(0).getLastName());
								//row[0] = list.get(i).getId();
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Login Sucessfull");
							agentDash.setVisible(true);
							login.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect username and password...");
						}
				}catch(IndexOutOfBoundsException ex) {
					System.out.println("Error occured" + ex.getMessage());
					ex.printStackTrace();
				}
					break;
					case "Representative":
						flag = client.recieveResponse();
						try {
						if (flag==true) {
							client.sendAction("Get Rep Info");
							client.sendAction(login.user.getText());
							try {
								ArrayList<Reps> list = new ArrayList<Reps>();
								
								list = client.recieveRep();
								list.get(0).getStuId();
								repDash.repFNameHeader.setText(list.get(0).getFirstName()); 
								repDash.repLNameHeader.setText(list.get(0).getLastName());
								//row[0] = list.get(i).getId();
							} catch (ClassNotFoundException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "Login Sucessfull");
							repDash.setVisible(true);
							login.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect username and password...");
						}
				}catch(IndexOutOfBoundsException ex) {
					System.out.println("Error occured" + ex.getMessage());
					ex.printStackTrace();
				}
						break;
				
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
			 client.sendComplaint(new Complaint(0, newComp.dateTxtField.getText(), newComp.timeTxtField.getText(), newComp.compCmbBox.getSelectedItem().toString(), newComp.compTxtArea.getText(), Integer.parseInt(newComp.stuIdTxtField.getText()), "unsolved"));
			 client.sendAction(login.user.getText());
			 if (client.recieveResponse()== true) {
				 JOptionPane.showMessageDialog(null, "Complaint Logged Sucessfull"); 
				try {
					 ArrayList<Complaint> solved1 = new ArrayList<Complaint>();
					ArrayList<Complaint> unsolved1 = new ArrayList<Complaint>();
					System.out.println("1");
					solved1 = client.recieveStuCmps();
					System.out.println("2");
					unsolved1 = client.recieveStuCmps();
					System.out.println("3");
					stuDash.finUnsolvedTxt.setText(String.valueOf(solved1.size()));
					System.out.println(String.valueOf(solved1.size()));
					stuDash.finSolvedTxt.setText(String.valueOf(unsolved1.size()));
					System.out.println(String.valueOf(unsolved1.size()));
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
	 
	 class listenForViewCompHlthMenuBttn implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				
				agentViewCompHlth.setVisible(true);
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
			 agentViewComp.cmpIdTxt.setText(model.getValueAt(i, 0).toString());
			 agentViewComp.dateTxt.setText(model.getValueAt(i, 1).toString());
			 agentViewComp.timeTxt.setText(model.getValueAt(i, 2).toString());
			 agentViewComp.typeTxt.setText(model.getValueAt(i, 3).toString());
			 agentViewComp.stuIdTxt.setText(model.getValueAt(i, 5).toString());
			 agentViewComp.textArea.setText(model.getValueAt(i, 4).toString());

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
	 
	 class listenForJTableClickedAdm implements MouseListener {
		 public void mouseClicked(MouseEvent arg0) {
			 int i = agentViewCompAdm.table.getSelectedRow();
			 TableModel model = agentViewCompAdm.table.getModel();
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
	 
	 
	 class listenForUpdateHlthBttn implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				ArrayList<Complaint> list = new ArrayList<Complaint>();
				client.sendAction("View Complaint Health");
				try {
					list =  client.recieveComplaintsHlth();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println(list.get(0));
				//System.out.println(list.get(1));
				//System.out.println(list.get(2));
				
				//Adding each item in the ArrayList to a row
				DefaultTableModel model = (DefaultTableModel) agentViewCompHlth.table.getModel();
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
	 
	 class listenForJTableClickedHlth implements MouseListener {
		 public void mouseClicked(MouseEvent arg0) {
			 int i = agentViewCompHlth.table.getSelectedRow();
			 TableModel model = agentViewCompHlth.table.getModel();
			 agentViewCompHlth.cmpIdTxt.setText(model.getValueAt(i, 0).toString());
			 agentViewCompHlth.dateTxt.setText(model.getValueAt(i, 1).toString());
			 agentViewCompHlth.timeTxt.setText(model.getValueAt(i, 2).toString());
			 agentViewCompHlth.typeTxt.setText(model.getValueAt(i, 3).toString());
			 agentViewCompHlth.stuIdTxt.setText(model.getValueAt(i, 5).toString());
			 agentViewCompHlth.textArea.setText(model.getValueAt(i, 4).toString());

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
	 
	

}
