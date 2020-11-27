package ServerController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import com.mysql.jdbc.Statement;

//import projectModel.Complaint;
import configuration.Server;
import factory.SessionFactoryBuilder;
import factory.dbConnector;
import projectModel.Complaint;
import ServerModel.Student;

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
	
	//In the main class/ driver class, it should be like this:
	/*public static void main(String[] args) {
	
		//to run save student
	studentHib studenthib = new studentHib();
	
	Student student = new Student();
	studenthib.saveStudent(student);
	
	//To updateStudent
	student.setFirstName("Lone");
	studenthib.updateStudent(student);
	
	//To run getStudentById
	Student student2 = studenthib.getStudentById(student.getStuId());
	
	//To run getAllStudents
	List<Student> students = studenthib.getAllStudents();
	students.forEach(student1 -> System.out.println(student.getStuId()));
	
	//To deleteStudents
	studenthib.deleteStudent(student.getStuId());
	
	}*/
	
	public static void main(String[] args) {
		ComplaintHib comp2 = new ComplaintHib();
		
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
