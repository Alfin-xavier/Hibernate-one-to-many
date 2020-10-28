package com.atmecs.hibernate_one_to_one.crud_operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import com.atmecs.hibernate_one_to_one.utility.HibernateUtility;

public class UpdateRecord 
{
	@Test
	public void updateRecord()
	{
		Scanner scan = new  Scanner(System.in);
		final Session session = HibernateUtility.getHibernateSession();
		try
		{
		    Transaction transaction=session.beginTransaction();

		    System.out.println("Enter the id to Update a record:");
			int id=scan.nextInt();
			
		    System.out.println("Which one you want to modify:\n 1.Name\n 2.Email");
			int choice = scan.nextInt();
			
			if(choice==1)
			{
				System.out.println("Enter the value to be Modify: ");
				String m_name = scan.next();
				String updateNameQuery = "UPDATE Manager_Details manager_det SET Manager_det.m_name='"+m_name+"' WHERE m_id='"+id+"'";
				session.createQuery(updateNameQuery).executeUpdate();
			}
			else
			{
				System.out.println("Enter the value to be Modify :");
				String m_email = scan.next();
				String updateEmailQuery = "UPDATE Manager_Details manager_det SET manager_det.m_email='"+m_email+"' WHERE m_id='"+id+"'";
				session.createQuery(updateEmailQuery).executeUpdate();
			}
			
			/*
			 * switch (choice) { case 1:
			 * System.out.println("Enter the value to be Modify :"); String
			 * name=scan.next(); String
			 * updateNameQuery="UPDATE User u SET u.name='"+name+"' WHERE userId='"+id+"'";
			 * session.createQuery(updateNameQuery).executeUpdate(); break; case 2:
			 * System.out.println("Enter the value to be Modify :"); String
			 * email=scan.next(); String
			 * updateEmailQuery="UPDATE User u SET u.email='"+email+"' WHERE userId='"+id+
			 * "'"; session.createQuery(updateEmailQuery).executeUpdate(); break; case 3:
			 * System.out.println("Enter the value to be Modify :"); String
			 * phoneNumber=scan.next(); String
			 * updateNumberQuery="UPDATE User u SET u.phoneNumber='"
			 * +phoneNumber+"' WHERE userId='"+id+"'";
			 * session.createQuery(updateNumberQuery).executeUpdate(); break; case 4:
			 * System.out.println("Enter the value to be Modify :"); String
			 * gender=scan.next(); String
			 * updateGenderQuery="UPDATE User u SET u.gender='"+gender+"' WHERE userId='"+id
			 * +"'"; session.createQuery(updateGenderQuery).executeUpdate(); break; default:
			 * System.out.println("Wrong Chocie"); break; }
			 */
			transaction.commit();
		}
		
		finally 
		{
			
			session.close();
		}
	}
	
}
