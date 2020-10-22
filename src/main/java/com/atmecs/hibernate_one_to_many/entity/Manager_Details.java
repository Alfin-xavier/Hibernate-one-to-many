package com.atmecs.hibernate_one_to_many.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager_details")
public class Manager_Details 
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private int m_id;
 
    @Column(name = "m_name")
    private String m_name;
 
    @Column(name = "m_email")
    private String m_email;
 
    @Column(name = "p_name")
    private int p_name;

	public int getM_id() {
		return m_id;
	}
	
	public Manager_Details()
	{
		
	}
	
	public Manager_Details(String m_name, String m_email)
	{
		this.m_name = m_name;
		this.m_email = m_email;
	}

	public void setM_id(int m_id) 
	{
		this.m_id = m_id;
	}

	public String getM_name() 
	{
		return m_name;
	}

	public void setM_name(String m_name) 
	{
		this.m_name = m_name;
	}

	public String getM_email()
	{
		return m_email;
	}

	public void setM_email(String m_email)
	{
		this.m_email = m_email;
	}

	public int getP_name() 
	{
		return p_name;
	}

	public void setP_name(int p_name) 
	{
		this.p_name = p_name;
	}
    
    
}
