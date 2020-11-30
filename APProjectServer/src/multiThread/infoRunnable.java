package multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ServerModel.Complaint;
import ServerModel.Student;

public class infoRunnable  implements Runnable{

	protected Socket clientSocket = null;
	private Student s;
	
	public infoRunnable(Socket clientSocket) {
		
		this.clientSocket = clientSocket;
		
	}
	
	@Override
	public void run() {

		try {
			//int id = 0;

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			//What ever is added here, or sent to the input reader, it uses it's name here to make an addition. 
			/*if(in.readLine().equals("newComplaint")) {
				
				String m1,m2,m3,m4;
				id = in.read();
				m1 = in.readLine();
				m2 = in.readLine();
				m3 = in.readLine();
				m4 = in.readLine();
								
				this.s = new Student();
				
			}*/
			
			
			
			
			//Shows message sent from client to server
			String message;
			message = in.readLine();
			System.out.println("Client output: "+message);
			
			//Shows message sent from the server to the client
			out.println("Thanks for the message");
			
		} catch (IOException e) {
			System.out.println("Error at creating a buffer reader.");
		}
		
	}
	
	
	//To run, use the SocketServer first, then the client
	//SocketServer ss = new SocketServer();
	//ss.runServer();
	
	//Now you need to tie in together the student and such classes,
	//where it makes the request and the server returns the info needed.

	
	
	
}