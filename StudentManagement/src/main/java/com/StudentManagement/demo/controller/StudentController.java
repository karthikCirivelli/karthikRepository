package com.StudentManagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.demo.dto.StudentInfoDto;
import com.StudentManagement.demo.dto.StudentInfoResponseDto;
import com.StudentManagement.demo.dto.StudentMarksDto;
import com.StudentManagement.demo.dto.StudentWithMarksDto;
import com.StudentManagement.demo.serviceimpl.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping(value ="/student/details" )
	public StudentInfoResponseDto saveStudentDetails(@RequestBody List<StudentInfoDto> studentInforDtoLits) {
		return studentServiceImpl.saveStudentDetails(studentInforDtoLits);
		
	}
	
	@GetMapping(value ="/student/details" )
	public List<StudentInfoDto> fetchStudentDetails() {
		return studentServiceImpl.fetchAllStudentDetails();
		
	}
	
	@PostMapping(value ="/student/marks/detail" )
	public StudentInfoResponseDto saveStudentMarksDto(@RequestBody StudentMarksDto StudentMarksDto) {
		return studentServiceImpl.saveStudentMarks(StudentMarksDto);
		
	}
	
	@GetMapping(value ="/student/details/{studentId}" )
	public StudentWithMarksDto fetchStudent(@PathVariable String studentId) {
		return studentServiceImpl.ftechStudentWithMarks(studentId);
		
	}


}
