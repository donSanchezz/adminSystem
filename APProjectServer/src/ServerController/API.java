package ServerController;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ServerModel.Complaint;
import configuration.Server;
import factory.SessionFactoryBuilder;


public class API {
	private static final Logger Logger = LogManager.getLogger(API.class);
	
	public Boolean insertComplaint (Complaint obj) {
		SessionFactoryBuilder session = new SessionFactoryBuilder();
		session.getSession();
		Transaction trans = null;
		
		try {
			Logger.warn("Attempting to create a session");
			trans = session.getSession().beginTransaction();
			session.getSession().save(obj);
			trans.commit();
			Logger.info("Record inserted Successfully");
			return true;
		}catch (RuntimeException ex) {
			if (trans != null) {
				Logger.error("An SQL Exception has occured" + ex.getMessage() + "Insertion failed");
				trans.rollback();
			}
			return false;
		}
		finally {
			session.getSession().flush();
			session.getSession().close();
		}
		
	}



	

}
