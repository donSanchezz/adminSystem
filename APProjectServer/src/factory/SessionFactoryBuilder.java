package factory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import projectModel.Comment;
import projectModel.Complaint;
import projectModel.Query;
import configuration.Server;


public class SessionFactoryBuilder {
	private static final Logger Logger = LogManager.getLogger(Server.class);
	private static SessionFactory session;

	public static SessionFactory getSessionFactory() {
		
		try {
		Logger.warn("Attempting to set-up Session for Complaint class");
		if(session == null) {
		session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Complaint.class).buildSessionFactory();
			
		Logger.info("Session successfully configured");
		}
		
		}catch(SessionException ex) {
			Logger.error("Session not configured" + ex.getMessage());
		}
		return session;

	}
	
public static SessionFactory getSessionFactoryQ() {
		
		try {
		Logger.warn("Attempting to set-up Session for Query class");
		if(session == null) {
		session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Query.class).buildSessionFactory();
			
		Logger.info("Session successfully configured");
		}
		
		}catch(SessionException ex) {
			Logger.error("Session not configured" + ex.getMessage());
		}
		return session;

	}

public static SessionFactory getSessionFactoryComment() {
	
	try {
	Logger.warn("Attempting to set-up Session for Comment class");
	if(session == null) {
	session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Comment.class).buildSessionFactory();
		
	Logger.info("Session successfully configured");
	}
	
	}catch(SessionException ex) {
		Logger.error("Session not configured" + ex.getMessage());
	}
	return session;

}

	public static void closeSessionFactory() {

		if(session != null) {
			session.close();
		}

	}

} 