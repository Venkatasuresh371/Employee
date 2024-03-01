package com.org.employee.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	private static final Logger logInfo = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public EmployeeResponse saveEmployee(EmployeeRequest empRequest)
	{
		logInfo.info("Employee Request in service ---> ",empRequest);
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

	private EmployeeResponse constructEmployeeResponse(Employee employee)
	{
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmpId(employee.getempId());
		employeeResponse.setName(employee.getName());
		employeeResponse.setDesignation(employee.getDesignation());
		employeeResponse.setContactNumber(employee.getContactNumber());
		employeeResponse.setJoiningDate(String.valueOf(employee.getJoiningDate()));
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
		logInfo.info("getEmployeeById methood ---> ",id);
		Employee employee = empRepository.findByEmpId(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found for the given employee id :: "+id));
		EmployeeResponse employeeResponse = constructEmployeeResponse(employee);
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getEmployeeByName(String name) 
	{
		Employee employee = empRepository.findByName(name)
				.orElseThrow(()->new EmployeeNotFoundException("Employee Not Found With Given Name :: "+name));
		EmployeeResponse employeeResponse = constructEmployeeResponse(employee);
		return employeeResponse;
	}

	@Override
	public EmployeeResponse updateEmployee(long id, EmployeeRequest empRequest) 
	{
		EmployeeResponse employeeResponse = null;
		logInfo.info("id ---> ",id);
		Employee oldEmployee = empRepository.findByEmpId(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found for the given employee id :: "+id));
		logInfo.info("Employee ---> ",oldEmployee.getempId());
		oldEmployee.setName(
				empRequest.getName()!= null ? empRequest.getName():oldEmployee.getName());
		oldEmployee.setContactNumber(
				empRequest.getContactNumber()!= null ? empRequest.getContactNumber():oldEmployee.getContactNumber());
		oldEmployee.setDesignation(
				empRequest.getDesignation()!= null ? empRequest.getDesignation():oldEmployee.getDesignation());
			
		Employee newEmployee = empRepository.save(oldEmployee);
		
		logInfo.info("after updating savedEmployee ---> ",newEmployee.getName());
		employeeResponse = constructEmployeeResponse(newEmployee);
		return employeeResponse;
	}

	@Override
	public String deleteEmployee(long id) 
	{
		Employee employee = empRepository.findByEmpId(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found for the given employee id :: "+id));
		empRepository.delete(employee);
		return "Employee Deleted Successfully";
	}

	@Override
	public List<EmployeeResponse> searchEmployees(String query) 
	{
		logInfo.info("input for searchEmployee method ---> ",query);
		List<Employee> employeeList = empRepository.searchEmployee(query);
		List<EmployeeResponse> employeeResponseList = constrctEmployeeResponseList(employeeList);
		logInfo.info("employeeResponseList ---> "+employeeResponseList.size());
		return employeeResponseList;
	}

	@Override
	public Page<EmployeeResponse> getPage(Integer pageNo, Integer size) 
	{
		Pageable pageable = PageRequest.of(pageNo,size);
		Page<Employee> page = empRepository.findAll(pageable);
		logInfo.info("Page Size ---> ",page.getSize());
		List<Employee> employeeList = page.getContent();
		logInfo.info("List Size ---> ",employeeList.size());
		List<EmployeeResponse> employeeResponseList = constrctEmployeeResponseList(employeeList);
		return new PageImpl<EmployeeResponse>(employeeResponseList,pageable,page.getTotalElements());
	}
}