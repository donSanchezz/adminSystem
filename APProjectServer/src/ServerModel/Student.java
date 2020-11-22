package ServerModel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import java.io.Serializable;

import org.hibernate.Session;
import factory.SessionFactoryBuilder;

@Entity
@Table(name="students")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contactNum")
	private int contactNum;
	
	public Student (int id, String firstName, String lastName, String email, int contactNum) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNum = contactNum;

	}
	
	public Student () {
		this.id = 1;
		this.firstName = "John";
		this.lastName = "Doe";
		this.email = "johndoe@gmail.com";
		this.contactNum = 8597198;

	}

	public void create() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		
		Transaction transaction = (Transaction) session.beginTransaction();
		session.save(this);
		try {
			transaction.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
	}
	
	public void update() {
		Session session = SessionFactoryBuilder.getSessionFactory().getCurrentSession();
		
		Transaction transaction = (Transaction) session.beginTransaction();
		Student stu = (Student) session.get(Student.class, this.id);
		stu.setFirstName(this.firstName);
		stu.setLastName(this.lastName);
		session.update(stu);
		try {
			transaction.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
	}
	
	public int getStuId() {
		return id;
	}

	public void setStuId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCantactNum() {
		return contactNum;
	}

	public void setCantNum(int contactNum) {
		this.contactNum = contactNum;
	}



	@Override
	public String toString() {
		return "Student [stuId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", cantNum=" + contactNum + "]";
	}
	
	
	public Student getStudent() {
		return this;
	}
}
