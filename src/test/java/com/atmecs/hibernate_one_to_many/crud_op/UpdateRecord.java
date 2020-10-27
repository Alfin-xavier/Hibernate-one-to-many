package com.atmecs.hibernate_one_to_many.crud_op;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import com.atmecs.hibernate_one_to_many.entity.Manager_Details;
import com.atmecs.hibernate_one_to_many.utility.HibernateUtility;

public class UpdateRecord 
{
	public  void displayRecord() 
	{
		Scanner scan=new Scanner(System.in);
	
	final Session session = HibernateUtility.getHibernateSession();
	try {
	    Transaction transaction=session.beginTransaction();
	    
	    System.out.println("Enter the id to see the Details :");
	    int id=scan.nextInt();
	    
	    String query="FROM manager_details where m_id='"+id+"'"+"";
	    
	    List<Manager_Details> list = session.createQuery(query).getResultList();
		System.out.println(list);
		
		transaction.commit();
		}
		catch (SessionException e)
		{
			System.out.println(e);
		} 
		finally 
		{

			session.close();
		}
}
}
