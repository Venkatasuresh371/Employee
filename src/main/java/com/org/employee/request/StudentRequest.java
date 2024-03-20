package com.org.employee.request;

public class StudentRequest 
{
	private String studentName;
	private String email;
	private String contactNo;
	private Integer studnetCourseId;
	
	public StudentRequest()
	{
		super();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getStudentCourseId() {
		return studnetCourseId;
	}

	public void setStudentCourseId(Integer studnetCourseId) {
		this.studnetCourseId = studnetCourseId;
	}
	
}
