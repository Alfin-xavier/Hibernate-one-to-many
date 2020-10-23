package com.atmecs.hibernate_one_to_many.cascade_op;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

import com.atmecs.hibernate_one_to_many.entity.Manager_Details;
import com.atmecs.hibernate_one_to_many.entity.Project_Details;

public class ManagerConfig 
{
	@Test
	public void configuration()
	{
		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Manager_Details.class)
									.addAnnotatedClass(Project_Details.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try
		{
			
			Manager_Details manager_det = new Manager_Details(454,"abc", "dfc@atmecs.com",101);
			
			Project_Details proj_det = new Project_Details(101,"Citrix", "3 Months");
			
			//manager_det.setManagerDetails(proj_det);
			
			session.beginTransaction();
			
			session.save(manager_det);
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
		}
	}
}
