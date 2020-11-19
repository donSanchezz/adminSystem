package ServerModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complaint")
public class Query extends DateTime{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="date")
	public String date;
	
	@Column(name="time")
	public String time;
	
	@Column(name="typeOfQuery")
	public String typeOfQuery;
	
	@Column(name="query")
	public String query;
	
	@Column(name="stuId")
	public int stuId;
	
	public Query(int id, String date, String time, String typeOfQuery, String query, int stuId) {
		super();
		this.id=id;
		this.date = date;
		this.time = time;
		this.typeOfQuery = typeOfQuery;
		this.query = query;
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

	public String getTypeOfQuery() {
		return typeOfQuery;
	}

	public void setTypeOfComplaint(String typeOfQuery) {
		this.typeOfQuery = typeOfQuery;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	
	
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String Date() {
		DateTime date = new DateTime();
		return date.Date();
	}
	
	public String Time () {
		DateTime time = new DateTime();
		return time.Time();
	}



	@Override
	public String toString() {
		return "Query [id=" + id + ", date=" + date + ", time=" + time + ", typeOfComplaint=" + typeOfQuery
				+ ", Query=" + query + ", stuId=" + stuId + "]";
	}

	
	
	
	
}
