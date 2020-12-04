 package ServerController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import projectModel.Student;
import configuration.Server;
import factory.SessionFactoryBuilder;
//import jdbc.connection.dbConnector;
import factory.dbConnector;
import projectModel.Complaint;

public class studentHib {
	private static final Logger Logger = LogManager.getLogger(Server.class);
	//Class for student update, display all, update, delete
	// Also get by an ID number. CRUD Operations.
	
	public void saveStudent(Student students) {
		
		
		Transaction transaction = null;
		
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			Logger.warn("Attempting to retrieve session from SessionFactoryBuilder");
			
			//Start the transaction
			transaction = session.beginTransaction();
			//Saving the student
			session.save(students);
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
	
	public Student getStudentById(int id) {
		
		Transaction transaction = null;
		Student students = null;
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Getting the student object
			students = session.get(Student.class, id);
			
			//Commit the transition
			transaction.commit();
			
		}catch(Exception e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			System.out.println("Error occurred");
		}
		return students;
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		
		Transaction transaction = null;
		List<Student> students = null;
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Get students
			students = session.createQuery("from students").list();
			
			//Commit the transition
			transaction.commit();
			
		}catch(Exception e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			System.out.println("Error occurred");
		}
		return students;
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
	
	public Boolean stuLogin (String username, String password) {
		Boolean flag = null;
	//getting a connection
	Logger.warn("Attempting to set-up a connection");
	Connection con = dbConnector.getConnection();
	Logger.info("Connecting successfull");
	//A query statement that gets the user input for username and view from the Login(View).
	try {
		Logger.warn("Attempting to create a statement from the connection");
		Statement stmt = con.createStatement();
		String loginSql = "Select * from students where id = '"+username+ "' and pass = '"+password+"'";
		Logger.info("Statement created and stored:" +loginSql);
		ResultSet rs = stmt.executeQuery(loginSql);
		Logger.warn("Attempting to verify user's credentials");
		if (rs.next()) {
			Logger.info("User's credentials are a match!");
			flag = true;
		}
		else {
			Logger.info("User's credentials are a not match!");
			flag = false;
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	return flag;
	}
	
	
	public ArrayList<Student> getStudentInfo(String ID) {
		
		ArrayList<Student> studentInfo = new ArrayList<>();
		
		//getting a connection
		Logger.warn("Attempting to set-up a connection");
		Connection con = dbConnector.getConnection();
		Logger.info("Connecting successfull");
		//A query statement that gets the user input for username and view from the Login(View).
		try {
			Logger.warn("Attempting to create a statement from the connection");
			Statement stmt = con.createStatement();
			String loginSql = "Select * from students where id = '"+ID+"'";
			Logger.info("Statement created and stored:" +loginSql);
			ResultSet rs = stmt.executeQuery(loginSql);
			Logger.warn("Attempting to assign user's information");
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				int contactNum = rs.getInt("contactNum");
				String pass = rs.getString("pass");
				
				Student stu = new Student();
				stu.setStuId(id);
				stu.setFirstName(firstName);
				stu.setLastName(lastName);
				stu.setEmail(email);
				stu.setCantNum(contactNum);
				stu.setPass(pass);
				
				studentInfo.add(stu);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return studentInfo;
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
	
}
