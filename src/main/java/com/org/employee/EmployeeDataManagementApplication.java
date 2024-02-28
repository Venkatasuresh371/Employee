package com.org.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmployeeDataManagementApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EmployeeDataManagementApplication.class, args);
	}
}