package com.org.employee.response;

import lombok.Data;

@Data
public class EmployeeResponse
{
	private long empId;
	private String name;
	private String designation;
	private String contactNumber;
	private String joiningDate;
}