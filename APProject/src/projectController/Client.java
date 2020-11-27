package projectController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.io.Serializable;

//import configuration.Server;
import projectModel.Complaint;
import projectModel.Query;
import projectModel.Student;

public class Client {
	private ObjectOutputStream os;
	private ObjectInputStream is;
	private Socket connection;
	
	
	//private Logger Logger = LogManager.getLogger(Client.class);
	private static final Logger Logger = LogManager.getLogger(Client.class);
	
	public Client () {
		this.createConnection();
		this.getStreams();
	}
	
	
	private void createConnection() {
		try {
			Logger.warn("Attempting to setup Client Socket, Erros may occur");
			connection = new Socket(InetAddress.getLocalHost(), 8888);
			Logger.info ("Socket Successfully Configred");
		}catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
		
	}
	
	public final void getStreams() {
		try {
			Logger.warn("Attempting to setup Output Socket, Errors may occur");
			os = new ObjectOutputStream (connection.getOutputStream());
			is = new ObjectInputStream (connection.getInputStream());
			Logger.warn("Socket setup successfull");
			
		}catch (IOException ex) {
			Logger.error(ex.getMessage());
		}
	}
	
	public void  closeConnection() {
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
	
	public void sendAction(String action) {
		try {
			Logger.warn("Attempting to send the action thats need to be performed to Server, Errors may occur");
			//Sending an action to the server as a string of what we wabt to achieve
			//Already serialized
			os.writeObject(action);
			Logger.info("Action  Successfully sent to Server");
			
		}catch (IOException ex) {
			Logger.error("Data not sent to server \n" +ex.getMessage());
		}
	}
	
	
	public void sendComplaint(Complaint obj) {
		try {
			Logger.warn("Attempting to send complaint information to Server, Errors may occur ");
			os.writeObject(obj);
			Logger.info("Complaint data Successfully sent to server");
		}catch (IOException ex) {
			Logger.error("Data not sent to server \n" + ex.getMessage());
		}
	}
	
	public void sendQuery(Query obj) {
		try {
			Logger.warn("Attempting to send query information to Server, Errors may occur ");
			os.writeObject(obj);
			Logger.info("Query data Successfully sent to server");
		}catch (IOException ex) {
			Logger.error("Data not sent to server \n" + ex.getMessage());
		}
	}
	
	public void sendStudent(Student stuObj) {
		try {
			Logger.warn("Attempting to send student information to Server, Errors may occur ");
			os.writeObject(stuObj);
			Logger.info("Data Successfully sent to server");
		}catch (IOException ex) {
			Logger.error("Data not Sent to server \n" + ex.getMessage());
		}
	}
	
	public Boolean recieveResponse() {
		Boolean val = null;
		try {
			Logger.warn("Attempting to recieve information from Server, Errors may occur");
			Boolean flag = (Boolean)is.readObject();
			Logger.info("Data Successfully Recieved from server");
			Logger.info ("Recieved: '"+ flag + "'from Server");
			val=flag;
			
		}catch (ClassCastException | ClassNotFoundException | IOException ex) {
			Logger.error(ex.getMessage());
		}
		return val;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> recieveComplaints() throws ClassNotFoundException, IOException {
		//ArrayList<Vozilo> list = new ArrayList<Vozilo>();
		//ArrayList<Complaint> list = new ArrayList<Complaint>();
		/*try {
			Logger.warn("Attempting to recieve information from Server, Errors may occur");
			//
			list  =  (ArrayList<Complaint>) is.readObject();
			Logger.info("All complaints Successfully Recieved from server");		
		}catch (ClassCastException | IOException ex) {
			Logger.error(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return (ArrayList<Complaint>) is.readObject();
	}
	
	/*public List<Complaint> recieveComplaints() {
		//ArrayList<Vozilo> list = new ArrayList<Vozilo>();
		ArrayList<Complaint> list = new ArrayList<Complaint>();
		try {
			Logger.warn("Attempting to recieve information from Server, Errors may occur");
			//for (int i =0; i<4; i++) {
			// System.out.println(is.readObject());
			//Complaint cmp = (Complaint) is.readObject();
			//System.out.println(cmp);
			//list.add(cmp); 
			//}
			/*for (Complaint cmp : list) {
			    System.out.println("IDs: " + cmp.getStuId() + "\n");
			}
		
			Object obj = null;
			System.out.println("Pass initialization");
			while ((obj = is.readObject()) != "stop") {
				System.out.println("Inside loop");
				obj = is.readObject();
			    if (obj instanceof Complaint) {
			    Complaint cmp = (Complaint) obj;
			    list.add(cmp);
			    System.out.println(cmp);
			    }
			    System.out.println("End of loop ");
			}
			
			/*for (Complaint cmp : list) {
			    System.out.println("Student: " + cmp.getStuId() + "\n");
			}
			Logger.info("All complaints Successfully Recieved from server");		
		}catch (ClassCastException | IOException ex) {
			Logger.error(ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<Complaint>) list;
	}*/
	
}
