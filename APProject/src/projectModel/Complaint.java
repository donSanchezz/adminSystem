package projectModel;



public class Complaint extends DateTime {
	
	public transient int id;
	public String date;
	public String time;
	public String typeOfComplaint;
	public String complaint;
	public int stuId;
	
	
	public Complaint(int id, String date, String time, String typeOfComplaint, String complaint, int stuId) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.typeOfComplaint = typeOfComplaint;
		this.complaint = complaint;
		this.stuId = stuId;
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



	@Override
	public String toString() {
		return "Complaint [id=" + id + ", date=" + date + ", time=" + time + ", typeOfComplaint=" + typeOfComplaint
				+ ", complaint=" + complaint + ", stuId=" + stuId + "]";
	}






	
	
	
	

}
