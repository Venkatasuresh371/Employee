package com.org.employee.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.employee.entity.Employee;
import com.org.employee.exceptions.EmployeeNotFoundException;
import com.org.employee.repository.EmployeeRepository;
import com.org.employee.request.EmployeeRequest;
import com.org.employee.response.EmployeeResponse;
import com.org.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public EmployeeResponse saveEmployee(EmployeeRequest empRequest)
	{
		Employee employee = constructEmployee(empRequest);
		Employee saveEmployee = empRepository.save(employee);
		EmployeeResponse employeeResponse = constructEmployeeResponse(saveEmployee);
		return employeeResponse;
	}

	private Employee constructEmployee(EmployeeRequest empRequest) 
	{
		Employee emp = new Employee();
		emp.setName(empRequest.getName());
		emp.setDesignation(empRequest.getDesignation());
		emp.setContactNumber(empRequest.getContactNumber());
		emp.setJoiningDate(LocalDateTime.now());
	    return emp;
	}

	private EmployeeResponse constructEmployeeResponse(Employee saveEmployee)
	{
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmpId(saveEmployee.getempId());
		employeeResponse.setName(saveEmployee.getName());
		employeeResponse.setDesignation(saveEmployee.getDesignation());
		employeeResponse.setContactNumber(saveEmployee.getContactNumber());
		employeeResponse.setJoiningDate(String.valueOf(saveEmployee.getJoiningDate()));
		return employeeResponse;
	}

	@Override
	public List<EmployeeResponse> getAllEmployee()
	{
		List<Employee> employeeList = empRepository.findAll();
		List<EmployeeResponse> employeeResponseList = constrctEmployeeResponseList(employeeList);
		return employeeResponseList;
	}

	private List<EmployeeResponse> constrctEmployeeResponseList(List<Employee> employeeList) 
	{
		List<EmployeeResponse> employeeResponseList = new ArrayList<EmployeeResponse>();
		for (Employee employee : employeeList) {
			EmployeeResponse employeeResponse = constructEmployeeResponse(employee);
			employeeResponseList.add(employeeResponse);
		}
		return employeeResponseList;
	}

	@Override
	public EmployeeResponse getEmployeeById(long id) 
	{
		Optional<Employee> optionalEmployee = empRepository.findByEmpId(id);
		if(optionalEmployee.isEmpty()) 
			throw new EmployeeNotFoundException("Employee not found for the given employee id :: "+id);
		EmployeeResponse employeeResponse = constructEmployeeResponse(optionalEmployee.get());
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getEmployeeByName(String name) 
	{
		Optional<Employee> optionalEmployee = empRepository.findByName(name);
		if(optionalEmployee.isEmpty())
			throw new EmployeeNotFoundException("Employee Not Found With Given Name :: "+name);
		EmployeeResponse employeeResponse = constructEmployeeResponse(optionalEmployee.get());
		return employeeResponse;
	}

	@Override
	public EmployeeResponse updateEmployee(long id, EmployeeRequest empRequest) 
	{
		EmployeeResponse employeeResponse = null;
		System.out.println("id:::: "+id);
		Optional<Employee> optionalEmployee = empRepository.findByEmpId(id);
		System.out.println("optionalEmployee :: "+optionalEmployee.get().getempId());
		if(optionalEmployee.isEmpty())
		{
			throw new EmployeeNotFoundException("Employee not found for the given employee id :: "+id);
		}
		Employee employee = optionalEmployee.get();
		employee.setName(empRequest.getName());
		employee.setContactNumber(empRequest.getContactNumber());
		employee.setDesignation(empRequest.getDesignation());
			
		Employee savedEmployee = empRepository.save(employee);
		System.out.println("after updating savedEmployee :: "+savedEmployee.getName());
		employeeResponse = constructEmployeeResponse(savedEmployee);
		return employeeResponse;
	}

	@Override
	public String deleteEmployee(long id) 
	{
		Optional<Employee> optionalEmployee = empRepository.findByEmpId(id);
		if(optionalEmployee.isEmpty())
			throw new EmployeeNotFoundException("Employee not found for the given employee id :: "+id);
		empRepository.deleteById(id);
		return "Employee Deleted Successfully";
	}

	@Override
	public List<EmployeeResponse> searchEmployees(String query) 
	{
		System.out.println("input for searchEmployee method  :: "+query);
		List<Employee> employeeList = empRepository.searchEmployee(query);
		List<EmployeeResponse> employeeResponseList = constrctEmployeeResponseList(employeeList);
		System.out.println("employeeResponseList :: "+employeeResponseList.size());
		return employeeResponseList;
	}
}