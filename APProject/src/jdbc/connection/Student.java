package jdbc.connection;

public class Student {

	private int stuId;
	private String firstName;
	private String lastName;
	private String email;
	private int cantNum;
	private String typeIssue;
	private String detailIssue;
	
	public Student (int stuId, String firstName, String lastName, String email, int cantNum, String typeIssue, String detailIssue) {
		this.stuId = stuId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cantNum = cantNum;
		this.typeIssue = typeIssue;
		this.detailIssue = detailIssue;
	}
	
	public Student () {
		this.stuId = 1;
		this.firstName = "John";
		this.lastName = "Doe";
		this.email = "johndoe@gmail.com";
		this.cantNum = 8597198;
		this.typeIssue = "Financial";
		this.detailIssue = "I haven't recieved my balance";
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
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

	public int getCantNum() {
		return cantNum;
	}

	public void setCantNum(int cantNum) {
		this.cantNum = cantNum;
	}

	public String getTypeIssue() {
		return typeIssue;
	}

	public void setTypeIssue(String typeIssue) {
		this.typeIssue = typeIssue;
	}

	public String getDetailIssue() {
		return detailIssue;
	}

	public void setDetailIssue(String detailIssue) {
		this.detailIssue = detailIssue;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", cantNum=" + cantNum + ", typeIssue=" + typeIssue + ", detailIssue=" + detailIssue + "]";
	}
	
	
	public Student getStudent() {
		return this;
	}
}
