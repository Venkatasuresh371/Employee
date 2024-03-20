package com.org.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.org.employee.request.EmployeeRequest;
import com.org.employee.response.EmployeeResponse;

public interface EmployeeService 
{
	public EmployeeResponse saveEmployee(EmployeeRequest empRequest);

	public List<EmployeeResponse> getAllEmployee();

	public EmployeeResponse getEmployeeById(long id);

	public EmployeeResponse getEmployeeByName(String name);

	public EmployeeResponse updateEmployee(long id, EmployeeRequest empRequest);

	public String deleteEmployee(long id);
	
	public List<EmployeeResponse> searchEmployees(String query);
	
	public Page<EmployeeResponse> getPage(int pageNo,int size);
	
	public Page<EmployeeResponse> getPage2(int pageNo);

}