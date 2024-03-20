package com.org.employee.request;

public class CourseRequest
{
	private String courseName;
	private String trainerName;
	private Integer studentCourseId;
	
	public CourseRequest() {
		super();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Integer getstudentCourseId() {
		return studentCourseId;
	}

	public void setstudentCourseId(Integer studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

}
