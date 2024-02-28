package com.org.employee.scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerDemo
{
	@Scheduled(cron = "10 58 13 28 2 3")
	public void m1()
	{
		System.out.println("Cron Job Running "+LocalDateTime.now());
	}
	
	@Scheduled(fixedRate = 2000)
	public void m2()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	    String strDate = dateFormat.format(new Date());
	    System.out.println("Job running at - "+ strDate);
	}
	
	@Scheduled(initialDelay = 4000)
	public void m3()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	    String strDate = dateFormat.format(new Date());
	    System.out.println("Job running at - "+ strDate);
	}
}