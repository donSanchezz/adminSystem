package projectDriver;

import java.awt.EventQueue;

import jdbc.connection.SQLOperations;
import jdbc.connection.dbConnector;
import projectController.Controller;
import projectView.Login;

public class ProjectDriver {

	public static void main(String[] args) {
		
		Login frame = new Login();
		new dbConnector();

		
		Controller con = new Controller(frame);
		frame.setVisible(true);
		
		
		
		
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

	

