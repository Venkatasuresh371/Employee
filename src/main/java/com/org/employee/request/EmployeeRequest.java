package com.org.employee.request;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeRequest {
	
	@NotBlank(message = "Name should not be blank")
	private String name;

	@NotBlank(message = "Designation should not be blank")
	private String designation;

	@Pattern(regexp = "^[0-9]{10}$")
	@Size(min = 10, max = 10)
	private long contactNumber;

	@NotBlank(message = "Joining Date should not be blank")
//	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private String joiningDate;

	EmployeeRequest() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
}