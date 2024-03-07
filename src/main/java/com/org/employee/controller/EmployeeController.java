package com.org.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.employee.request.EmployeeRequest;
import com.org.employee.response.EmployeeResponse;
import com.org.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	private static final Logger logInfo = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/")
	public ResponseEntity<String> getData()
	{
		String string = "Welcome to Employee Data Management";
		return new ResponseEntity<String>(string,HttpStatus.OK);
	}
	@PostMapping("/saveemployee")
	public ResponseEntity<EmployeeResponse> saveEmployee(@Valid @RequestBody EmployeeRequest empRequest)
	{
		logInfo.info("Employee Request ---> ",empRequest);
		
		if(empRequest != null)
		{
			EmployeeResponse employeeResponse = empService.saveEmployee(empRequest);
			logInfo.info("Employee Response ---> ",employeeResponse);
			return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.CREATED);
		}
		return new ResponseEntity<EmployeeResponse>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getallemployee")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee()
	{
		List<EmployeeResponse> allEmployees = empService.getAllEmployee();
		logInfo.info("Employee List Size ---> ",allEmployees.size());
		return new ResponseEntity<List<EmployeeResponse>>(allEmployees,HttpStatus.OK);
	}
	
	@GetMapping("/employeebyid/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable long id)
	{
		logInfo.info("Employee Id ---> ",id);
		EmployeeResponse employeeResponse = empService.getEmployeeById(id);
		logInfo.info("Employee Response ---> ",employeeResponse);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
	}
	
	@GetMapping("/employeebyname/{name}")
	public ResponseEntity<EmployeeResponse> getEmployeeByName(@PathVariable String name)
	{
		EmployeeResponse employeeResponse = empService.getEmployeeByName(name);
		logInfo.info("Employee Response ---> ",employeeResponse);
		return new ResponseEntity<EmployeeResponse>(employeeResponse,HttpStatus.OK);
	}
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployee(@Valid @PathVariable long id,
			@RequestBody EmployeeRequest empRequest)
	{
		EmployeeResponse updatedEmployeeResponse = empService.updateEmployee(id, empRequest);
		logInfo.info("updatedEmployeeResponse ---> ",updatedEmployeeResponse);
		return new ResponseEntity<EmployeeResponse>(updatedEmployeeResponse,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id)
	{
		String string = empService.deleteEmployee(id);
		return new ResponseEntity<String>(string,HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<EmployeeResponse>> searchEmployees(@RequestParam String query)
	{
		List<EmployeeResponse> employeeResponse = empService.searchEmployees(query);
		logInfo.info("EmployeeResponse ---> ",employeeResponse);
		return new ResponseEntity<List<EmployeeResponse>>(employeeResponse,HttpStatus.OK);
	}
	
	@GetMapping("/getemployeebypage")
	public ResponseEntity<Page<EmployeeResponse>> getEmployeeByPage(@RequestParam Integer pageNo,
			@RequestParam Integer pageSize)
	{
		Page<EmployeeResponse> page = empService.getPage(pageNo, pageSize);
		return new ResponseEntity<Page<EmployeeResponse>>(page,HttpStatus.OK);
	}
}