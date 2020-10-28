package com.atmecs.hibernate_one_to_one.tests;

import org.testng.annotations.Test;

import com.atmecs.hibernate_one_to_one.crud_operations.CrudMenu;

public class OneToOneMapping 
{
	@Test
	public void employee_details() throws Exception
	{
		CrudMenu menu = new CrudMenu();
		
		menu.operations();
	}
}
