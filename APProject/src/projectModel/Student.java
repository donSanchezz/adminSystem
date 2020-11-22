package projectModel;

import java.io.Serializable;

public class Student implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
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
