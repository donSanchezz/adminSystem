package projectModel;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;
import factory.SessionFactoryBuilder;

@Entity
@Table(name="reps")
public class Reps implements Serializable {

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
	
	@Column(name="pass")
	private String pass;
	
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinTable(name="student_complaint_table", joinColumns=@JoinColumn(name="id"), inverseJoinColumns=JoinColumn(name="id"))
	private ArrayList<Complaint> complaintList = new ArrayList<>();
	
	public Reps (int id, String firstName, String lastName, String email, int contactNum, String pass) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNum = contactNum;
		this.pass = pass;

	}
	
	public Reps () {
		this.id = 1;
		this.firstName = "John";
		this.lastName = "Doe";
		this.email = "johndoe@gmail.com";
		this.contactNum = 8597198;
		this.pass=null;

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

	

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<Complaint> getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(ArrayList<Complaint> complaintList) {
		this.complaintList = complaintList;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", cantNum=" + contactNum + "]";
	}
	
	
	public Reps getRep() {
		return this;
	}
}
