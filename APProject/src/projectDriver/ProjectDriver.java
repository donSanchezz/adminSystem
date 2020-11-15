package projectDriver;

import java.awt.EventQueue;

import jdbc.connection.SQLOperations;
import jdbc.connection.dbConnector;
import projectController.Controller;
import projectView.Login;
import projectView.StuDashboard;

public class ProjectDriver {

	public static void main(String[] args) {
		
		Login loginFrame = new Login();
		StuDashboard stuDashFrame = new StuDashboard();
		new dbConnector();

		
		Controller con = new Controller(loginFrame, stuDashFrame);
		stuDashFrame.setVisible(true);
		//loginFrame.setVisible(true);
		
		
		
		
		
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

	

