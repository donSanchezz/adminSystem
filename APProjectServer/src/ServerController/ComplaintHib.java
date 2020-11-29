package ServerController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

//import com.mysql.jdbc.Statement;

//import projectModel.Complaint;
import configuration.Server;
import factory.SessionFactoryBuilder;
import factory.dbConnector;
import projectModel.Agent;
import projectModel.Complaint;
import projectModel.Student;

public class ComplaintHib {
	
	dbConnector con;
	private static final Logger Logger = LogManager.getLogger(Server.class);
	//Class for student update, display all, update, delete
	// Also get by an ID number. CRUD Operations.
	
	public void saveComplaint(projectModel.Complaint comObj) {
		
		
		Transaction transaction = null;
		
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			Logger.warn("Attempting to retrieve session from SessionFactoryBuilder");
			
			//Start the transaction
			transaction = session.beginTransaction();
			//Saving the student
			session.save(comObj);
			//Commit the transition
			transaction.commit();
			
				
			 
			Logger.info("Session retrieved, data committed");
		}catch(SessionException ex) {
			
			if(transaction != null){
				
			transaction.rollback();
		
			
			}
			Logger.error("Trouble configuring session, not successful" + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void updateStudent(Student students) {
		
		Transaction transaction = null;
		
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			
		
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Saving the student
			session.saveOrUpdate(students);
			
			//Commit the transition
			transaction.commit();
			
		}catch(Exception e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			System.out.println("Error occurred");
		}
	}
	
	public Complaint getComplaintById(int id) {
		
		Transaction transaction = null;
		Complaint complaint = null;
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			//Start the transaction
			transaction = session.beginTransaction();
			//Getting the student object
			
			complaint = session.get(Complaint.class, id);
			System.out.println(complaint);
			
			//Commit the transition
			transaction.commit();
			
		}catch(Exception e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			System.out.println("Error occurred");
		}
		return complaint;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllComplaintFinancial() {
		
		Transaction transaction = null;
		ArrayList<Complaint> complaintList = new ArrayList<>();
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			Logger.warn("Starting transacting to get all complaints");
			//Start the transaction
			transaction = session.beginTransaction();
			Logger.info("Transaction retrieved to get all complaints.");
			//Get students
			
			Logger.warn("Starting query to get all complaints");
			complaintList =  (ArrayList<Complaint>) session.createQuery("from Complaint c where c.typeOfComplaint='Financial'").getResultList();
			Logger.info("Query retrieved to get all financial complaints.");
			
			//Commit the transition
			Logger.warn("Attempting to commit transaction");
			transaction.commit();
			Logger.info("Transaction successfully committed");
			
		}catch(HibernateException e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			Logger.error("An error has occured" + e.getMessage());
			e.printStackTrace();
		}
		return complaintList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllComplaintAdmin() {
		
		Transaction transaction = null;
		ArrayList<Complaint> complaintList = new ArrayList<>();
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			Logger.warn("Starting transacting to get all administration complaints");
			//Start the transaction
			transaction = session.beginTransaction();
			Logger.info("Transaction retrieved to get all administration complaints.");
			//Get students
			
			Logger.warn("Starting query to get all administration complaints");
			complaintList =  (ArrayList<Complaint>) session.createQuery("from Complaint c where c.typeOfComplaint='Administration'").getResultList();
			Logger.info("Query retrieved to get all administration complaints.");
			
			//Commit the transition
			Logger.warn("Attempting to commit transaction");
			transaction.commit();
			Logger.info("Transaction successfully committed");
			
		}catch(HibernateException e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			Logger.error("An error has occured" + e.getMessage());
			e.printStackTrace();
		}
		return complaintList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Complaint> getAllComplaintHlth() {
		
		Transaction transaction = null;
		ArrayList<Complaint> complaintList = new ArrayList<>();
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			Logger.warn("Starting transacting to get all health complaints");
			//Start the transaction
			transaction = session.beginTransaction();
			Logger.info("Transaction retrieved to get all health complaints.");
			//Get students
			
			Logger.warn("Starting query to get all health complaints");
			complaintList =  (ArrayList<Complaint>) session.createQuery("from Complaint c where c.typeOfComplaint='Health'").getResultList();
			Logger.info("Query retrieved to get all health complaints.");
			
			//Commit the transition
			Logger.warn("Attempting to commit transaction");
			transaction.commit();
			Logger.info("Transaction successfully committed");
			
		}catch(HibernateException e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			Logger.error("An error has occured" + e.getMessage());
			e.printStackTrace();
		}
		return complaintList;
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public void deleteStudent(int id) {
		
		Transaction transaction = null;
		Student students = null;
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			
			//Start the transaction
			transaction = session.beginTransaction();
			
			students = session.get(Student.class, id);
			//Get students
			
			session.delete(students);
			//Commit the transition
			transaction.commit();
			
		}catch(Exception e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			System.out.println("Error occurred");
		}

	}
	
	public ArrayList<Complaint> getSolvedComplaintById(String ID) {
		
		ArrayList<Complaint> cmpInfo = new ArrayList<>();
		
		//getting a connection
		Logger.warn("Attempting to set-up a connection");
		Connection con = dbConnector.getConnection();
		Logger.info("Connecting successfull");
		//A query statement that gets the user input for username and view from the Login(View).
		try {
			Logger.warn("Attempting to create a statement from the connection");
			Statement stmt = con.createStatement();
			String solved = "solved";
			String sql = "Select  * from complaint  where stuId = '"+ID+"' and status = '"+solved+"' ";
			Logger.info("Statement created and stored:" +sql);
			ResultSet rs = stmt.executeQuery(sql);
			Logger.warn("Attempting to assign user's information");
			Complaint cmp = new Complaint();
			while (rs.next()) {
				int id = rs.getInt("id");
				String date = rs.getString("date");
				String time = rs.getString("time");
				String typeOfComplaint = rs.getString("typeOfComplaint");
				String complaint = rs.getString("complaint");
				int stuId = rs.getInt("stuId");
				String status = rs.getString("status");
				
				
				cmp.setId(id);
				cmp.setDate(date);
				cmp.setTime(time);
				cmp.setTypeOfComplaint(typeOfComplaint);
				cmp.setComplaint(complaint);
				cmp.setStuId(stuId);
				cmp.setStatus(status);
				
				cmpInfo.add(new Complaint(id, date, time, typeOfComplaint, complaint, stuId, status));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println(cmpInfo);
		return cmpInfo;
	}
	
	
public ArrayList<Complaint> getUnsolvedComplaintById(String ID) {
		
		ArrayList<Complaint> cmpInfo = new ArrayList<>();
		
		//getting a connection
		Logger.warn("Attempting to set-up a connection");
		Connection con = dbConnector.getConnection();
		Logger.info("Connecting successfull");
		//A query statement that gets the user input for username and view from the Login(View).
		try {
			Logger.warn("Attempting to create a statement from the connection");
			Statement stmt = con.createStatement();
			String unsolved = "unsolved";
			String sql = "Select  * from complaint  where stuId = '"+ID+"' and status = '"+unsolved+"' ";
			Logger.info("Statement created and stored:" +sql);
			ResultSet rs = stmt.executeQuery(sql);
			Logger.warn("Attempting to assign user's information");
			Complaint cmp = new Complaint();
			while (rs.next()) {
				int id = rs.getInt("id");
				String date = rs.getString("date");
				String time = rs.getString("time");
				String typeOfComplaint = rs.getString("typeOfComplaint");
				String complaint = rs.getString("complaint");
				int stuId = rs.getInt("stuId");
				String status = rs.getString("status");
				
				
				cmp.setId(id);
				cmp.setDate(date);
				cmp.setTime(time);
				cmp.setTypeOfComplaint(typeOfComplaint);
				cmp.setComplaint(complaint);
				cmp.setStuId(stuId);
				cmp.setStatus(status);
				
				cmpInfo.add(new Complaint(id, date, time, typeOfComplaint, complaint, stuId, status));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.println(cmpInfo);
		return cmpInfo;
	}
	
	public static void main(String[] args) {
		ComplaintHib comp2 = new ComplaintHib();
		comp2.getSolvedComplaintById("1");
		//System.out.println(comp2.getComplaintById(11));
		//comp2.getAllComplaint();
		//System.out.println(comp2.getAllComplaint());
		
		/*List<Complaint> cmp = new ArrayList<>();
		cmp = comp2.getAllComplaint();
		System.out.println(cmp.get(0));
		System.out.println(cmp.get(1));
		System.out.println(cmp.get(2));*/
		
		
	}
}
