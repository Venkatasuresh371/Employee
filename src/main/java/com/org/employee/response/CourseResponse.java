package com.org.employee.response;

public class CourseResponse 
{
	private int courseId;
	private String courseName;
	private String trainerName;
	private Integer studentCourseId;
	
	public CourseResponse() {
		super();
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
