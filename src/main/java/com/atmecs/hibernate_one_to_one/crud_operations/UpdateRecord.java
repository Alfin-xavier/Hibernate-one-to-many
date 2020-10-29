package com.atmecs.hibernate_one_to_one.crud_operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import com.atmecs.hibernate_one_to_one.utility.HibernateUtility;

public class UpdateRecord 
{
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
				String name = scan.next();
				String updateNameQuery = "UPDATE Manager_Details manager_det SET manager_det.m_name='"+name+"' WHERE m_id='"+id+"'";
				session.createQuery(updateNameQuery).executeUpdate();
			}
			else
			{
				System.out.println("Enter the value to be Modify :");
				String email = scan.next();
				String updateEmailQuery = "UPDATE Manager_Details manager_det SET manager_det.m_email='"+email+"' WHERE m_id='"+id+"'";
				session.createQuery(updateEmailQuery).executeUpdate();
			}
			
			transaction.commit();
		}
		
		finally 
		{
			
			session.close();
		}
	}
	
}
