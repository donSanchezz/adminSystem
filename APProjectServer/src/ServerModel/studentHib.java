 package ServerModel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import factory.SessionFactoryBuilder;

public class studentHib {

	//Class for student update, display all, update, delete
	// Also get by an ID number. CRUD Operations.
	
	public void saveStudent(Student students) {
		
		Transaction transaction = null;
		
		try(Session session = SessionFactoryBuilder.getSessionFactory().openSession()){
			
			//Start the transaction
			transaction = session.beginTransaction();
			
			//Saving the student
			session.save(students);
			
			//Commit the transition
			transaction.commit();
			
		}catch(Exception e) {
			
			if(transaction != null){
				
			transaction.rollback();
			
			}
			System.out.println("Error occurred");
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
	
	//In the main class/ driver class, it should be like this:
	public static void main(String[] args) {
	
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
	
	}
	
}
