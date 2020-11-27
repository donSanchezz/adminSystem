package configuration;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//import projectModel.Complaint;
import projectModel.Complaint;
import projectModel.Query;

import java.io.Serializable;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ServerController.ComplaintHib;
import ServerController.QueryHib;
import ServerModel.Student;
import ServerModel.studentHib;

public class Server {

	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket connection;
	private ServerSocket servSock;
	private Student student;
	private Complaint complaint;
	
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
		try {
			while(true) {
		Logger.info("Server waiting for connections");
		connection = servSock.accept();
		Logger.info ("Client requests accepted");
		this.getStream();
		do {
			try {
				Logger.warn("Attempting to recieve data of whats operation to be done from client, Errors may occur");
				//Reading the string that was sent over from the Client server...the request that should be processed.
				action = (String) is.readObject();
				Logger.info ("Data Successfully recieved from client");
				switch (action) {
				case "Add Complaint":
					Logger.warn("Attempting to recieve complaint data from client, Erros may occur");
					Complaint comObj = (Complaint)is.readObject();
					Logger.info("Complaint data successfully recieved from client");
					//Add complaint
					ComplaintHib com = new ComplaintHib();
					com.saveComplaint(comObj);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(true);
					Logger.info("Data Successfully sent from client");
					break;
				case "Add Query":
					Logger.warn("Attempting to recieve query data from client, Erros may occur");
					Query stuQuery = (Query)is.readObject();
					Logger.info("Query data Successfully recieved from client");
					//Add student
					QueryHib queryHib = new QueryHib();
					queryHib.saveQuery(stuQuery);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(true);
					Logger.info("Data Successfully sent from client");
					break;
				case "View Complaint Financial":
					Logger.warn("Attempting to recieve query data from client, Erros may occur");
					//Complaint viewComp = (Complaint)is.readObject();
					ComplaintHib cmpHib = new ComplaintHib();
					Logger.info("Query data Successfully recieved from client");
					//Add student
					//QueryHib queryHib = new QueryHib();
					//queryHib.saveQuery(stuQuery);
					Logger.warn("Attempting to send data to client, Errors may occur");
					ArrayList<Complaint> list = cmpHib.getAllComplaintFinancial();
					
					//for (int i =0; i<list.size(); i++) {
						os.writeObject(list);
						System.out.println(list);
					//}
					
					Logger.info("Data Successfully sent from client");
					break;
				case "View Complaint Admin":
					Logger.warn("Attempting to recieve query data from client, Erros may occur");
					//Complaint viewComp = (Complaint)is.readObject();
					ComplaintHib cmpHib1 = new ComplaintHib();
					Logger.info("Query data Successfully recieved from client");
					//Add student
					//QueryHib queryHib = new QueryHib();
					//queryHib.saveQuery(stuQuery);
					Logger.warn("Attempting to send data to client, Errors may occur");
					ArrayList<Complaint> list2 = cmpHib1.getAllComplaintFinancial();
					
					//for (int i =0; i<list.size(); i++) {
						os.writeObject(list2);
						System.out.println(list2);
					//}
					
					Logger.info("Data Successfully sent from client");
					break;
				}
			}catch (ClassNotFoundException | ClassCastException ex) {
				Logger.error("An error has occured" + ex.getMessage());
				ex.printStackTrace();
				os.writeObject(false);
			}catch(Exception ex1){
				Logger.error("An error has occued" + ex1.getMessage());
				ex1.printStackTrace();
			}
		}while(!action.contentEquals("Exit"));
		this.closeConnection();
		
	}
	
		}catch (Exception ex) {
			Logger.warn("An error has occured");
		}
	}
	
	

}
