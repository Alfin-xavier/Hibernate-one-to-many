package com.atmecs.hibernate_one_to_many.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.atmecs.hibernate_one_to_many.entity.Manager_Details;
import com.atmecs.hibernate_one_to_many.entity.Project_Details;

public class HibernateUtility 
{
	public static Session getHibernateSession() {
		final SessionFactory factory = new Configuration().addAnnotatedClass(Manager_Details.class)
				.addAnnotatedClass(Project_Details.class)
		        .configure("hibernate.cfg.xml").buildSessionFactory();
		final Session session = factory.openSession();
	    return session;
	}
}
