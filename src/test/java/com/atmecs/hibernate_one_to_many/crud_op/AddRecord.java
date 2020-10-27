package com.atmecs.hibernate_one_to_many.crud_op;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import com.atmecs.hibernate_one_to_many.entity.Manager_Details;
import com.atmecs.hibernate_one_to_many.entity.Project_Details;
import com.atmecs.hibernate_one_to_many.utility.HibernateUtility;

public class AddRecord {
	@Test
	public void addRecord() {

		Scanner scan = new Scanner(System.in);
		final Session session = HibernateUtility.getHibernateSession();
		try {
			Transaction transaction = session.beginTransaction();

			System.out.println("Enter the number of records you want to Add :");

			int quantity = scan.nextInt();

			for (int i = 1; i <= quantity; i++) {
				System.out.println("Enter the no.of details :" + i);

				System.out.println("Enter the Manager Name :");
				String m_name = scan.next();
				System.out.println("Enter the Mail:");
				String mail = scan.next();

				System.out.println("Enter the Project Name :");
				String p_name = scan.next();
				System.out.println("Enter Duration: ");
				String p_duration = scan.next();

				Project_Details proj_det = new Project_Details();
				
				proj_det.setManager_det(new Manager_Details(m_name, mail));

				proj_det.setP_name(p_name);
				proj_det.setP_duration(p_duration);

				proj_det.setManager_det(new Manager_Details(p_name, p_duration));

				session.save(proj_det);

			}
			transaction.commit();
		} 
		finally 
		{
			session.close();
		}
	}
}
