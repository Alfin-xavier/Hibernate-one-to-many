package com.atmecs.hibernate_one_to_many.crud_op;

import java.util.List;
import java.util.Scanner;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionException;

import com.atmecs.hibernate_one_to_many.entity.Manager_Details;
import com.atmecs.hibernate_one_to_many.utility.HibernateUtility;

public class DeleteRecord 
{
	public void deleteRecord() throws Exception
	{

		Scanner scan = new Scanner(System.in);
		
		final Session session = HibernateUtility.getHibernateSession();
		
		try 
		{
			Transaction transaction = (Transaction) session.beginTransaction();	
			
			System.out.println("Enter the Id of the User to Delete :");
			int id = scan.nextInt();
			
			String query = "FROM Manager_Details where m_id='" + id + "'" + "";
			
			List<Manager_Details> list = session.createQuery(query).getResultList();
			System.out.println(list);
			for (Manager_Details manager_det : list) 
			{
				String name = manager_det.getM_name();
				System.out.println("User Name :" + name);
				session.delete(manager_det);
			}
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
