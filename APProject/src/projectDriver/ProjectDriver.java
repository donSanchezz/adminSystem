package projectDriver;

import java.awt.EventQueue;

import jdbc.connection.SQLOperations;
import jdbc.connection.dbConnector;
import projectController.Client;
import projectController.Controller;
import projectModel.Complaint;
import projectModel.DateTime;
import projectView.Login;
import projectView.StuDashboard;

public class ProjectDriver {

	public static void main(String[] args) {
		
		DateTime dt = new DateTime();
		//Complaint complaint;
		
		Client client = new Client();
		client.sendAction("Add Complaint");
		
		client.sendComplaint(new Complaint(0, dt.Date(), dt.Time(), "Finance", "I have paid 500, but it hasn't show on my portal", 0));
		
		client.recieveResponse();
		
		/*Login loginFrame = new Login();
		StuDashboard stuDashFrame = new StuDashboard();
		new dbConnector();

		
		Controller con = new Controller(loginFrame, stuDashFrame);
		stuDashFrame.setVisible(true);
		//loginFrame.setVisible(true); */
		
		
		
		
		
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

	

