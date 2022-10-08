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
@Table(name = "STUDENT_MARKS")
public class StudentMarks {
    @Id
    @Column(name = "STUDENT_ID")
    private int studentId;
    @Column(name = "SESSION")
    private String session;
    @Column(name = "SEMESTER")
    private String semester;
    @Column(name = "TOTAL_SUBJECT")
    private int totalSubject;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getTotalSubject() {
		return totalSubject;
	}
	public void setTotalSubject(int totalSubject) {
		this.totalSubject = totalSubject;
	}
    
}
