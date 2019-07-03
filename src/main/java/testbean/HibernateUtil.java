package testbean;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() throws HibernateException{
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        
            
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry  serviceRegistry = new ServiceRegistryBuilder().applySettings
             (configuration.getProperties()).buildServiceRegistry();   
            System.out.println("Hibernate serviceRegistry created");
              sessionFactory = configuration.buildSessionFactory(serviceRegistry);
     return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            
        }
		return sessionFactory;
    }
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
	   
	
	
	
}