package com.org.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.employee.entity.Student;
import com.org.employee.response.StudentCourseResponse;

public interface StudentRepository  extends JpaRepository<Student,Integer>
{
	@Query("select com.org.employee.response.StudentCourseResponse(s.studentName,c.courseName) from "
			+ "Student s inner join Course c on s.studentCourseId = c.studentCourseId")
	public List<StudentCourseResponse> getDetails(Integer studentCourseId);
}
