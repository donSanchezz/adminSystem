package multiThreadServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class infoRunnable  implements Runnable{

	protected Socket clientSocket = null;
	
	public infoRunnable(Socket clientSocket) {
		
		this.clientSocket = clientSocket;
		
	}
	
	@Override
	public void run() {

		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			
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

	
	
	
}
