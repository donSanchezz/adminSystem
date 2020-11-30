package clientThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientinfo {

	
	
	public static void main(String[] args) {
		
		String host = "127.0.0.1";
		int portNumber = 8888;
		
		Socket clientSocket;
		
		PrintWriter out;
		BufferedReader in;
		InputStreamReader read;
				
		try {
			
			clientSocket = new Socket(host, portNumber);
			//Creating IO STREAMS to check
			
			out = new PrintWriter(clientSocket.getOutputStream(), true); //TRUE means to flush the buffer  once info has been sent out.
			read = new InputStreamReader(clientSocket.getInputStream());
			in = new BufferedReader(read);
			
			//Checking to see what is sent is recieved by the server and seeing what is returned.
			out.println("Pass in info");
			in.readLine();
			System.out.println("Server responds: "+in.readLine());
			
		}catch(IOException e) {
			System.out.println("Error at the client class with threading");
			System.exit(1);
		}
		
	}
	
}
