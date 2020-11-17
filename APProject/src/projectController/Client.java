package projectController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import projectModel.Complaint;

public class Client {
	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket connection;
	
	
	private Logger Logger = LogManager.getLogger(Client.class);
	
	public Client () {
		this.createConnection();
		this.getStreams();
	}
	
	
	private void createConnection () {
		try {
			Logger.warn("Attempting to setup Client Socket, Erros may occur");
			connection = new Socket(InetAddress.getLocalHost(), 8888);
			Logger.info ("Socket Successfully COnfigred");
		}catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
		
	}
	
	public final void getStreams () {
		try {
			Logger.warn("Attempting to setup Socket, Errors may occur");
			os = new ObjectOutputStream (connection.getOutputStream());
			is = new ObjectInputStream (connection.getInputStream());
			
		}catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
	}
	
	public void  closeConnection () {
		try {
			Logger.warn("Attempting to close Client Streams to Server, Errors may occur");
			os.close();
			is.close();
			connection.close();
			Logger.info("Client Streams Successfully Closed to Server");
		}catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
	}
	
	public void sendAction (String action) {
		try {
			Logger.warn("Attempting to send information to Server, Errors may occur");
			//Sending an action to the server as a string of what we wabt to achieve
			//Already serialized
			os.writeObject(action);
			Logger.info("Client Streams Successfully Closed to Server");
			
		}catch (IOException ex) {
			Logger.error("Data not sent to server \n" +ex.getMessage());
		}
	}
	
	
	public void sendComplaint (Complaint obj) {
		try {
			Logger.warn("Attempting to send information to Server, Errors may occur ");
			os.writeObject(obj);
			Logger.info("Data Successfully sent to server");
		}catch (IOException ex) {
			Logger.error("Data not Sent to server \n" + ex.getMessage());
		}
	}
	
	
	public void recieveResponse () {
		try {
			Logger.warn("Attempting to recieve information from Server, Errors may occur");
			Boolean flag = (Boolean)is.readObject();
			Logger.info("Date Successfully Recieve from server");
			Logger.info ("Recieved: '"+ flag + "'from Server");
		}catch (ClassCastException | ClassNotFoundException | IOException ex) {
			Logger.error(ex.getMessage());
		}
	}
	
}
