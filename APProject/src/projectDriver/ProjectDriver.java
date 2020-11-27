package projectDriver;

import java.awt.EventQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.connection.SQLOperations;
import jdbc.connection.dbConnector;
import projectController.Client;
import projectController.Controller;
import projectModel.Complaint;
import projectModel.DateTime;
import projectModel.Student;
import projectView.AgentDashboard;
import projectView.AgentViewCompaint;
import projectView.AgentViewComplaintAdm;
import projectView.Login;
import projectView.StuDashboard;
import projectView.newComplaint;
import projectView.newQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProjectDriver {

	public static void main(String[] args) {
		//Client client = new Client();
		DateTime dt = new DateTime();
		//Complaint complaint;
		
		//Client client = new Client();
		//client.sendAction("Add Complaint");
		//client.sendAction("Add Student");
		//client.sendComplaint(new Complaint(0, "23", "23", "Finance", "I have paid 500, but it hasn't show on my portal", 0));
		//Student stuObj = new Student(10, "Alexis", "Garcia", "alexisgarcia@gmail.com", 99999);
		//client.sendStudent(new Student(10, "Alexis", "Garcia", "alexisgarcia@gmail.com", 99999));
		//client.recieveResponse();
		//client.sendAction("Exit");
		
		
		
		
		
		/*Login loginFrame = new Login();
		new dbConnector(); */
		
		Login loginFrame = new Login();
		StuDashboard stuDashFrame = new StuDashboard();
		newComplaint newComplaint = new newComplaint();
		newQuery newQuery = new newQuery();
		AgentDashboard agentDash = new AgentDashboard();
		AgentViewCompaint agentViewComp = new AgentViewCompaint();
		AgentViewComplaintAdm agentViewCompAdm = new AgentViewComplaintAdm();
		
		Controller con = new Controller(loginFrame, stuDashFrame, newComplaint, newQuery, agentDash, agentViewComp, agentViewCompAdm );
		//stuDashFrame.setVisible(true);
		
		agentDash.setVisible(true);
		//loginFrame.setVisible(true); */
		
		/*final Logger Logger = LogManager.getLogger(ProjectDriver.class);
		Logger.info("Test Info message");
		Logger.debug("Test Debug message");
		Logger.error("Test error message");
		Logger.trace("Test trace message");
		Logger.fatal("Test fatal message");
		Logger.warn("Test warning message");*/
		
		
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		
	
	}
	
	
	
	
	
}

	

