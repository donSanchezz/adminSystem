package projectModel;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="complaint")
public class Complaint extends DateTime implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public  int id;
	
	@Column(name="date")
	public String date;
	
	@Column(name="time")
	public String time;
	
	@Column(name="typeOfComplaint")
	public String typeOfComplaint;
	
	@Column(name="complaint")
	public String complaint;
	
	@Column(name="stuId")
	public int stuId;
	
	@Column(name="status")
	public String status;
	

public Complaint(){
		
	}
	
	public Complaint(int id, String date, String time, String typeOfComplaint, String complaint, int stuId, String status) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.typeOfComplaint = typeOfComplaint;
		this.complaint = complaint;
		this.stuId = stuId;
		this.status = status;
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public String getTypeOfComplaint() {
		return typeOfComplaint;
	}

	public void setTypeOfComplaint(String typeOfComplaint) {
		this.typeOfComplaint = typeOfComplaint;
	}


	public String getComplaint() {
		return complaint;
	}


	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}


	public String  Date () {
	DateTime date = new DateTime();
	return date.Date();
	}
	
	public String Time() {
	DateTime time = new DateTime();
	return time.Time();
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Complaint [id=" + id + ", date=" + date + ", time=" + time + ", typeOfComplaint=" + typeOfComplaint
				+ ", complaint=" + complaint + ", stuId=" + stuId + ", status=" + status + "]";

}
}
