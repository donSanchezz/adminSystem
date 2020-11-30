package multiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	int portNumber = 8888;
	ServerSocket serverSocket = null;
	
	
	public void runServer() {
		try {
			
			serverSocket = new ServerSocket(portNumber);
			
		}catch(IOException e) {
			System.out.println("Error occurred in the creation of the server socket");
		}
		
		while(true) {
			try {
				
				Socket clientSocket = serverSocket.accept();
				new Thread(new infoRunnable(clientSocket)).start();
				
			}catch(IOException e) {
				System.out.println("Error in the true section of run server.");
			}
		}
		
	}

}
