package com.org.employee.request;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeRequest 
{
	@NotNull
	@NotEmpty(message = "Employee Name should not be empty ")
	private String name;
	
	@NotEmpty()
	private String designation;
	
	
	  @Pattern(regexp = "^[0-9]{10}$")
	  
	  @Size(min = 6,max = 10)
	 
	private long contactNumber;
	
	@NotEmpty(message = "Joining Date should not be empty")
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private String joiningDate;
	
	EmployeeRequest() 
	{
		super();
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

	public String getJoiningDate() 
	{
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate)
	{
		this.joiningDate = joiningDate;
	}
}