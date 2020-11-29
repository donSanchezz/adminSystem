package configuration;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import projectModel.Agent;
//import projectModel.Complaint;
import projectModel.Complaint;
import projectModel.Query;
import projectModel.Reps;

import java.io.Serializable;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ServerController.AgentHib;
import ServerController.ComplaintHib;
import ServerController.QueryHib;
import ServerController.RepsHib;
import ServerController.studentHib;
import projectModel.Student;

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
		studentHib stuHib = new studentHib();
		AgentHib agtHib = new AgentHib();
		ComplaintHib cmpHib = new ComplaintHib();
		QueryHib queryHib = new QueryHib();
		RepsHib repHib = new RepsHib();
		ArrayList<Complaint> cmpList;
		ArrayList<Complaint> cmpList2;
		ArrayList<Student> stuList;
		ArrayList<Agent> agtList;
		ArrayList<Reps> repList;
		String username;
		String password;
		Boolean flag;
		String ID;
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
				Logger.info ("Data Successfully recieved from client" + action);
				switch (action) {
				case "Student":
					Logger.warn("Attempting to recieve login data from client, Erros may occur");
					username = (String) is.readObject();
					password = (String) is.readObject();
					Logger.info("Login data successfully recieved from client");
					//Add complaint
					flag = stuHib.stuLogin(username, password);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(flag);
					Logger.info("Data Successfully sent from client");
					break;
				case "Get Student Info":
					Logger.warn("Attempting to student login data from client, Erros may occur");
					 ID = (String) is.readObject();
					Logger.info("Student Login data successfully recieved from client");
					//Add complaint
					 stuList = stuHib.getStudentInfo(ID);
					 cmpList= cmpHib.getSolvedComplaintById(ID);
					 cmpList2 = cmpHib.getUnsolvedComplaintById(ID);
					 System.out.println(cmpList);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(stuList);
					os.writeObject(cmpList);
					os.writeObject(cmpList2);
					Logger.info("Data Successfully sent from client");
					break;
				case "Agent":
					Logger.warn("Attempting to recieve agent login data from client, Erros may occur");
					 username= (String) is.readObject();
					 password = (String) is.readObject();
					Logger.info("Login data successfully recieved from client");
					//Add complaint
					flag = agtHib.agentLogin(username, password);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(flag);
					Logger.info("Data Successfully sent from client");
					break;
				case "Get Agent Info":
					Logger.warn("Attempting to agent data from client, Erros may occur");
					ID = (String) is.readObject();
					Logger.info("Agent Login data successfully recieved from client");
					//Add complaint
					 agtList = agtHib.getAgentInfo(ID);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(agtList);
					Logger.info("Data Successfully sent from client");
					break;
				case "Representative":
					Logger.warn("Attempting to recieve agent login data from client, Erros may occur");
					 username= (String) is.readObject();
					 password = (String) is.readObject();
					Logger.info("Login data successfully recieved from client");
					//Add complaint
					flag = repHib.repsLogin(username, password);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(flag);
					Logger.info("Data Successfully sent from client");
					break;
				case "Get Rep Info":
					Logger.warn("Attempting to rep data from client, Erros may occur");
					ID = (String) is.readObject();
					Logger.info("Rep Login data successfully recieved from client");
					//Add complaint
					repList = repHib.getRepInfo(ID);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(repList);
					Logger.info("Data Successfully sent from client");
					break;
				case "Add Complaint":
					Logger.warn("Attempting to recieve complaint data from client, Erros may occur");
					Complaint comObj = (Complaint)is.readObject();
					 ID = (String) is.readObject();
				
					Logger.info("Complaint data successfully recieved from client");
					//Add complaint
					ComplaintHib com = new ComplaintHib();
					com.saveComplaint(comObj);
					 cmpList= cmpHib.getSolvedComplaintById(ID);
					 cmpList2 = cmpHib.getUnsolvedComplaintById(ID);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(true);
					System.out.println("3");
					os.writeObject(cmpList);
					System.out.println("4");
					os.writeObject(cmpList2);
					System.out.println("5");
					Logger.info("Data Successfully sent from client");
					break;
				case "Add Query":
					Logger.warn("Attempting to recieve query data from client, Erros may occur");
					Query stuQuery = (Query)is.readObject();
					Logger.info("Query data Successfully recieved from client");
					//Add student
					queryHib.saveQuery(stuQuery);
					Logger.warn("Attempting to send data to client, Errors may occur");
					os.writeObject(true);
					Logger.info("Data Successfully sent from client");
					break;
				case "View Complaint Financial":
					Logger.warn("Attempting to recieve query data from client, Erros may occur");
					Logger.info("Query data Successfully recieved from client");
					Logger.warn("Attempting to send data to client, Errors may occur");
					 cmpList = cmpHib.getAllComplaintFinancial();
						os.writeObject(cmpList);
						System.out.println(cmpList);
					Logger.info("Data Successfully sent from client");
					break;
				case "View Complaint Admin":
					Logger.warn("Attempting to recieve query data from client, Erros may occur");
					Logger.info("Query data Successfully recieved from client");
					Logger.warn("Attempting to send data to client, Errors may occur");
					cmpList = cmpHib.getAllComplaintFinancial();
						os.writeObject(cmpList);
						System.out.println(cmpList);
					Logger.info("Data Successfully sent from client");
					break;
				case "View Complaint Health":
					Logger.warn("Attempting to recieve query data from client, Erros may occur");
					Logger.info("Query data Successfully recieved from client");
					Logger.warn("Attempting to send data to client, Errors may occur");
					 cmpList = cmpHib.getAllComplaintHlth();
						os.writeObject(cmpList);
						System.out.println(cmpList);
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
