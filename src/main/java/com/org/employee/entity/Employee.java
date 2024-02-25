package com.org.employee.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_data")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	@Column(name = "name")
	private String name;
	@Column(name = "designation")
	private String designation;
	@Column(name = "contact_no")
	private long contactNumber;
	@Column(name = "joining_date")
	private LocalDateTime joiningDate;
	
	public Employee() 
	{
		super();
	}
	
	public long getempId()
	{
		return empId;
	}

	public void setempId(long empId) 
	{
		this.empId = empId;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}

	public long getContactNumber() 
	{
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) 
	{
		this.contactNumber = contactNumber;
	}

	public LocalDateTime getJoiningDate() 
	{
		return joiningDate;
	}

	public void setJoiningDate(LocalDateTime joiningDate)
	{
		this.joiningDate = joiningDate;
	}
}