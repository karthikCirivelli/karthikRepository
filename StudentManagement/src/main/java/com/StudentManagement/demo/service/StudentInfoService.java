package com.StudentManagement.demo.service;

import java.util.List;

import com.StudentManagement.demo.dto.StudentInfoDto;
import com.StudentManagement.demo.dto.StudentInfoResponseDto;
import com.StudentManagement.demo.dto.StudentMarksDto;
import com.StudentManagement.demo.dto.StudentWithMarksDto;

public interface StudentInfoService {

	StudentInfoResponseDto saveStudentDetails(List<StudentInfoDto> studentInforDtoLits);

	List<StudentInfoDto> fetchAllStudentDetails();

	StudentInfoResponseDto saveStudentMarks(StudentMarksDto studentMarksDto);
	
	StudentWithMarksDto ftechStudentWithMarks(String studentId);
}
