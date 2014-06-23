package ht;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private	static final SessionFactory	sessionFactory = build();
	public static SessionFactory getSessionFactory () {
		return sessionFactory;
	}
	private	static SessionFactory build ()
	{
		try {
			Configuration configuration	= new Configuration();
			configuration.configure();
			ServiceRegistry	serviceRegistry	= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			return configuration.buildSessionFactory( serviceRegistry );
		}
		catch (	Throwable ex) {
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}
