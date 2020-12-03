package ServerController;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import configuration.Server;
import factory.SessionFactoryBuilder;
import factory.dbConnector;
import projectModel.Comment;
import projectModel.Complaint;

public class CommentHib {
	private static final Logger Logger = LogManager.getLogger(Server.class);
	
public void saveComment(Comment cmtObj) {
		
		
		Transaction transaction = null;
		
		try(Session session = SessionFactoryBuilder.getSessionFactoryComment().openSession()){
			Logger.warn("Attempting to retrieve session from SessionFactoryBuilder");
			
			//Start the transaction
			transaction = session.beginTransaction();
			//Saving the comment
			session.save(cmtObj);
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


public ArrayList<Comment> getCommentsById(String ID) {
	
	ArrayList<Comment> cmtInfo = new ArrayList<>();
	
	//getting a connection
	Logger.warn("Attempting to set-up a connection");
	Connection con = dbConnector.getConnection();
	Logger.info("Connecting successfull");
	//A query statement that gets the user input for username and view from the Login(View).
	try {
		Logger.warn("Attempting to create a statement from the connection");
		Statement stmt = con.createStatement();
		String sql = "Select  * from comment  where cmpId = '"+ID+"' ";
		Logger.info("Statement created and stored:" +sql);
		ResultSet rs = stmt.executeQuery(sql);
		Logger.warn("Attempting to assign comment's information");
		Comment cmt = new Comment();
		while (rs.next()) {
			int id = rs.getInt("id");
			String date = rs.getString("date");
			String time = rs.getString("time");
			String comment = rs.getString("comment");
			int cmpId = rs.getInt("cmpId");
			int repId = rs.getInt("repId");
			
			
			cmt.setId(id);
			cmt.setDate(date);
			cmt.setTime(time);
			cmt.setComment(comment);
			cmt.setCmpId(cmpId);
			cmt.setRepId(repId);
			
			cmtInfo.add(new Comment(id, date, time, comment, cmpId, repId ));

		}
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
	
	System.out.println(cmtInfo);
	return cmtInfo;
}







}
