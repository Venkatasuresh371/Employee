package com.org.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(info =  @Info(title = "Employee Data Management",version = "3.2.2",description = "API's for employee data management"))
public class EmployeeDataManagementApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EmployeeDataManagementApplication.class, args);
	}
}