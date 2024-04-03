package com.org.employee.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmployeeRequest {
	
	@NotEmpty(message = "name Should not be empty")
	private String name;

	@NotEmpty(message = "Designation Should not be empty")
	private String designation;
	
	private String contactNumber;

	@NotBlank(message = "Joining Date should not be blank")
	private String joiningDate;
}