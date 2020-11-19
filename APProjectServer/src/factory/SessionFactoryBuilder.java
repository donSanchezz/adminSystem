package factory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ServerModel.Student;

public class SessionFactoryBuilder {

	private static SessionFactory session;
	
	public static SessionFactory getSessionFactory() {
		
		if(session == null) {
			new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		}
		
		return session;
		
	}
	
	public static void closeSessionFactory() {
		
		if(session != null) {
			session.close();
		}
		
	}

}