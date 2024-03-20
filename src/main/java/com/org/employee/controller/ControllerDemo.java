package com.org.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.employee.entity.Course;
import com.org.employee.entity.Student;
import com.org.employee.repository.CourseRepository;
import com.org.employee.repository.StudentRepository;
import com.org.employee.request.CourseRequest;
import com.org.employee.request.StudentRequest;
import com.org.employee.response.CourseResponse;
import com.org.employee.response.StudentCourseResponse;
import com.org.employee.response.StudentResponse;

@RestController
public class ControllerDemo
{
	@Autowired
	private StudentRepository stdRepo;
	
	@Autowired
	private CourseRepository courRepo;
	

	@PostMapping("savestudent")
	public ResponseEntity<StudentResponse> saveStudent(@RequestBody StudentRequest request)
	{
		Student student =costructStudent(request);
		Student savedStudent = stdRepo.save(student);
		StudentResponse response = costructStudentResponse(savedStudent);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}


	private StudentResponse costructStudentResponse(Student student)
	{
		StudentResponse response = new StudentResponse();
		response.setStudentId(student.getStudentId());
		response.setStudentName(student.getStudentName());
		response.setEmail(student.getEmail());
		response.setContactNo(student.getContactNo());
		response.setStudentCourseId(student.getstudentCourseId());
		return response;
	}


	private Student costructStudent(StudentRequest request)
	{
		Student student = new Student();
		student.setStudentName(request.getStudentName());
		student.setEmail(request.getEmail());
		student.setContactNo(request.getContactNo());
		student.setstudentCourseId(request.getStudentCourseId());		
		return student;
	}
	
	@PostMapping("savecourse")
	public ResponseEntity<CourseResponse> saveCourse(@RequestBody CourseRequest request)
	{
		Course course =costructCourse(request);
		Course savedCourse = courRepo.save(course);
		CourseResponse response = costructCourseResponse(savedCourse);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}


	private CourseResponse costructCourseResponse(Course course)
	{
		CourseResponse response = new CourseResponse();
		response.setCourseId(course.getCourseId());
		response.setCourseName(course.getCourseName());
		response.setTrainerName(course.getTrainerName());
		response.setstudentCourseId(course.getstudentCourseId());
		return response;
	}


	private Course costructCourse(CourseRequest request)
	{
		Course course = new Course();
		course.setCourseName(request.getCourseName());
		course.setTrainerName(request.getTrainerName());
		course.setstudentCourseId(request.getstudentCourseId());		
		return course;
	}
	
	@GetMapping("getstudentcourse/{studentCourseId}")
	public ResponseEntity<List<StudentCourseResponse>> getStudentCourse(@PathVariable Integer studentCourseId)
	{
		List<StudentCourseResponse> studentCourseResponse = stdRepo.getDetails(studentCourseId);
		return new ResponseEntity<>(studentCourseResponse,HttpStatus.OK);
	}
}
