package ServerController;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import configuration.Server;
import factory.SessionFactoryBuilder;
import projectModel.Comment;

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

}
