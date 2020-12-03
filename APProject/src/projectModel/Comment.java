package projectModel;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="comment")
public class Comment extends  DateTime implements Serializable {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
public  int id;
	
@Column(name="date")
public String date;
	
@Column(name="time")
public String time;
	

@Column(name="comment")
public String comment;
	
@Column(name="cmpId")
public int cmpId;

@Column(name="repId")
public int repId;

public Comment () {
	
}


public Comment(int id, String date, String time, String comment, int cmpId, int repId) {
	super();
	this.id = id;
	this.date = date;
	this.time = time;
	this.comment = comment;
	this.cmpId = cmpId;
	this.repId = repId;
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

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public int getCmpId() {
	return cmpId;
}

public void setCmpId(int cmpId) {
	this.cmpId = cmpId;
}



public int getRepId() {
	return repId;
}


public void setRepId(int repId) {
	this.repId = repId;
}


@Override
public String toString() {
	return "Comment [id=" + id + ", date=" + date + ", time=" + time + ", comment=" + comment + ", cmpId=" + cmpId
			+ ", repId=" + repId + "]";
}




	

}
