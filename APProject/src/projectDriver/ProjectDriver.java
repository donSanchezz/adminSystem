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
	
		loginFrame.setVisible(true);
	
		
	
	}
	
	
	
	
	
}

	

