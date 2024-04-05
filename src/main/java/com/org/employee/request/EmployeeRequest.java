package com.org.employee.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
	
	@NotEmpty(message = "name Should not be empty")
	@JsonProperty(value = "name")
	private String name;

	@NotEmpty(message = "Designation Should not be empty")
	@JsonProperty(value = "designation")
	private String designation;
	
	@JsonProperty(value = "ph.no")
	private String contactNumber;

	@NotBlank(message = "Joining Date should not be blank")
	@JsonProperty(value = "joining_date")
	private String joiningDate;
}