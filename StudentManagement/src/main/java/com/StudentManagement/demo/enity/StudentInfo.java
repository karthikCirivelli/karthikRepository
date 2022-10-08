package com.StudentManagement.demo.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo {
	
	@Id
	@Column(name = "STUDENT_ID")
	private int studentId;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name= "EMAIL")
	private String studentEmail; 
    
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "SECTION")
	private String section;
	
	@Column(name = "GRADE")
	private String grade;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}