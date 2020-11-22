package factory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ServerModel.Student;

public class SessionFactoryBuilder {
	
	public static final Configuration config = new Configuration ();
	public static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() throws HibernateException {
		
		if(sessionFactory == null) {
			//new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
			//new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			config.configure("hibernate.cfg.xml");
		}
		
		return sessionFactory;
		
	}
	
	public Session getSession() {
		SessionFactory factory = getSessionFactory();
		if (factory != null) {
			return factory.openSession();
		}
		else {
			return null;
		}
	}
	
	public static void closeSessionFactory() {
		
		if(sessionFactory != null) {
			sessionFactory.close();
		}
		
	}

}