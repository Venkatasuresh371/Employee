package com.org.employee.scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.org.employee.entity.Employee;
import com.org.employee.repository.EmployeeRepository;

@Component
public class SchedulerDemo
{
	@Autowired
	private EmployeeRepository repository;
	
//	@Scheduled(cron = "10 51 13 29 2 4")
	public void m1()
	{
		System.out.println("Cron Job Running "+LocalDateTime.now());
		List<Employee> list = repository.findAll();
		for (Employee employee : list) 
		{
			System.out.println(employee.getempId()+"--->"+employee.getName());
		}
	}
	
//	@Scheduled(fixedRate = 2000)
	public void m2()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	    String strDate = dateFormat.format(new Date());
	    System.out.println("Job running at - "+ strDate);
	}
}