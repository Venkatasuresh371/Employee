package com.org.employee.response;

public class EmployeeResponse
{
	private long empId;
	private String name;
	private String designation;
	private String contactNumber;
	private String joiningDate;
	
	public EmployeeResponse()
	{
		super();
	}

	public long getEmpId()
	{
		return empId;
	}
	public void setEmpId(long empId) 
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
	public String getContactNumber() 
	{
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) 
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
	@Override
	public String toString() 
	{
		return "EmployeeResponse [empId=" + empId + ", name=" + name + ", designation=" + designation
				+ ", contactNumber=" + contactNumber + ", joiningDate=" + joiningDate + "]";
	}
	
}