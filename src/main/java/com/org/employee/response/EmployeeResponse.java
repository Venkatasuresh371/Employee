package com.org.employee.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse
{
	private long empId;
	private String name;
	private String designation;
	private String contactNumber;
	private String joiningDate;
}