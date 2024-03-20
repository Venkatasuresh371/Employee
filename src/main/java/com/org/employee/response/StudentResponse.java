package com.org.employee.response;

public class StudentResponse
{
	private int studentId;
	private String studentName;
	private String email;
	private String contactNo;
	private Integer studnetCourseId;
	
	public StudentResponse()
	{
		super();
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
