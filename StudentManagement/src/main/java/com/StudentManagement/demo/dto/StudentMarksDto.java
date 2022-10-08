package com.StudentManagement.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentMarksDto {
	
	    private int studentId;
	    private String session;
	    private String semester;
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
