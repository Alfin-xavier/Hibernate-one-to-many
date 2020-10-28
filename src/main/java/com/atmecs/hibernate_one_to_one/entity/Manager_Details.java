package com.atmecs.hibernate_one_to_one.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
 
    @JoinColumn(name ="p_id")
   	@OneToOne(cascade = CascadeType.ALL)
    private Project_Details proj_det;

	public int getM_id() 
	{
		return m_id;
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

	public Project_Details getProj_det() 
	{
		return proj_det;
	}

	public void setProj_det(Project_Details proj_det) 
	{
		this.proj_det = proj_det;
	}

	public Manager_Details(String m_name, String m_email) 
	{
		this.m_name = m_name;
		this.m_email = m_email;
	}

	public Manager_Details() 
	{

	}

  
}
