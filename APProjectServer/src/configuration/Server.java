package configuration;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ServerModel.Complaint;

public class Server {

	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket connection;
	private ServerSocket servSock;
	
	private static final Logger Logger = LogManager.getLogger(Server.class);
			
	public Server() {
		this.createConnection();
		this.waitForRequests();
	}
	
	private void createConnection () {
		try {
			Logger.warn("Attempting to setup Server Socket, Errors may occur");
			
			servSock = new ServerSocket(8888, 1);
			Logger.info ("Server Socket Successfully Configured");
			
		}
		catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
	}
	
	
	public void getStream () {
		try {
			Logger.warn ("Attempting to setup Server Streams to client, Errors may occur");
			os = new ObjectOutputStream (connection.getOutputStream());
			is = new ObjectInputStream(connection.getInputStream());
			Logger.info("Server Streams Successfully Configured to Client");
		}catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
	}
	
	public void closeConnection () {
		try {
			Logger.warn("Attempting to close Server Stream to client, Errors may occur");
			os.close();
			is.close();
			connection.close();
			Logger.info("Server Streams Successfully closed to client");
			
		}catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
	}
	
	
	private void waitForRequests() {
		String action = "";
		Logger.info("Server waiting for connections");
		connection = servSock.accept();
		Logger.info ("Client requests accepted");
		this.getStream();
		do {
			try {
				Logger.warn("Attempting to recieve data from client, Errors may occur");
				//Reading the string that was sent over from the Client server...the request that should be processed.
				action = (String) is.readObject();
				Logger.info ("Data Successfully recieve from client");
				switch (action) {
				case "Add Complaint":
					Logger.warn("Attempting to recieve data from client, Erros may occur");
					Complaint obj = (Complaint)is.readObject();
					Logger.info("Data Successfully recieved from client");
					//Add complaint
					
					
				}while();
			}
		}
	}
	
	
	
















}
