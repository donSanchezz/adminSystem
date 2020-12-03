package projectDriver;

import java.awt.EventQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jdbc.connection.SQLOperations;
import jdbc.connection.dbConnector;
import projectController.Client;
import projectController.Controller;
import projectModel.Comment;
import projectModel.Complaint;
import projectModel.DateTime;
import projectModel.Student;
import projectView.AgentDashboard;
import projectView.AgentViewCompaint;
import projectView.AgentViewComplaintAdm;
import projectView.AgentViewComplaintHlth;
import projectView.Login;
import projectView.RepDashboard;
import projectView.RepViewComplaint;
import projectView.StuDashboard;
import projectView.StuViewComp;
import projectView.newComplaint;
import projectView.newQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProjectDriver {

	public static void main(String[] args) {
		//Client client = new Client();
		//DateTime dt = new DateTime();
		//Complaint complaint;
		
		//Client client = new Client();
		//client.sendAction("Add Complaint");
		//client.sendAction("Add Comment");
		//client.sendComment(new Comment(0, dt.Date(), dt.Time(), "test", 1));
		//client.sendComplaint(new Complaint(0, "23", "23", "Finance", "I have paid 500, but it hasn't show on my portal", 0));
		//Student stuObj = new Student(10, "Alexis", "Garcia", "alexisgarcia@gmail.com", 99999);
		//client.sendStudent(new Student(10, "Alexis", "Garcia", "alexisgarcia@gmail.com", 99999));
		//client.recieveResponse();
		//client.sendAction("Exit");
		
		
		
		
		
		/*Login loginFrame = new Login();
		new dbConnector(); */
		
		Login loginFrame = new Login();
		StuDashboard stuDashFrame = new StuDashboard();
		RepDashboard repDash = new RepDashboard();
		newComplaint newComplaint = new newComplaint();
		newQuery newQuery = new newQuery();
		AgentDashboard agentDash = new AgentDashboard();
		AgentViewCompaint agentViewComp = new AgentViewCompaint();
		AgentViewComplaintAdm agentViewCompAdm = new AgentViewComplaintAdm();
		AgentViewComplaintHlth agentViewCompHlth = new AgentViewComplaintHlth();
		RepViewComplaint repViewComp = new RepViewComplaint();
		StuViewComp stuViewComp = new StuViewComp();
		
		Controller con = new Controller(loginFrame, stuDashFrame, repDash, newComplaint, newQuery, agentDash, agentViewComp, agentViewCompAdm, agentViewCompHlth, repViewComp, stuViewComp );
		//stuDashFrame.setVisible(true);
	
		loginFrame.setVisible(true);
		//repViewComp.setVisible(true);
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

	

