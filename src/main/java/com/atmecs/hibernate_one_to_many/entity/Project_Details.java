package com.atmecs.hibernate_one_to_many.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_details")
public class Project_Details 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int p_id;
	
	@OneToOne(mappedBy = "proj_det", cascade = { CascadeType.MERGE, CascadeType.PERSIST,
												CascadeType.DETACH, CascadeType.REFRESH})
	private Manager_Details manager_det;
 
    @Column(name = "p_name")
    private String p_name;
 
    @Column(name = "p_duration")
    private String p_duration;
    
	public Project_Details(String p_name, String p_duration) 
	{
		this.p_name = p_name;
		this.p_duration = p_duration;
				
	}

	public int getP_id() 
	{
		return p_id;
	}

	public void setP_id(int p_id) 
	{
		this.p_id = p_id;
	}

	public String getP_name()
	{
		return p_name;
	}

	public void setP_name(String p_name) 
	{
		this.p_name = p_name;
	}

	public String getP_duration() 
	{
		return p_duration;
	}

	public void setP_duration(String p_duration) 
	{
		this.p_duration = p_duration;
	}

}
