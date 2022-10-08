package com.StudentManagement.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.demo.dto.StudentInfoDto;
import com.StudentManagement.demo.dto.StudentInfoResponseDto;
import com.StudentManagement.demo.dto.StudentMarksDto;
import com.StudentManagement.demo.dto.StudentWithMarksDto;
import com.StudentManagement.demo.enity.StudentInfo;
import com.StudentManagement.demo.enity.StudentMarks;
import com.StudentManagement.demo.repository.StudentRepository;
import com.StudentManagement.demo.service.StudentInfoService;
import com.StudentManagement.demo.repository.StudentMarksRepository;

@Service
public class StudentServiceImpl implements StudentInfoService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentMarksRepository StudentMarksRepository;

	@Override
	public StudentInfoResponseDto saveStudentDetails(List<StudentInfoDto> studentInforDtoLits) {
		int nofStudents = 0;
		StudentInfoResponseDto StudentInfoResponseDto = new StudentInfoResponseDto();
		for(StudentInfoDto StudentInfoDto : studentInforDtoLits) {
			StudentInfo StudentInfo = new StudentInfo();
			formStudentEmtity(StudentInfoDto ,StudentInfo);
			nofStudents ++;
		}
		
		return formResponseDto(StudentInfoResponseDto, nofStudents);
	}

	private StudentInfoResponseDto formResponseDto(StudentInfoResponseDto studentInfoResponseDto, int nofStudents) {
		String addedStudents = Integer.toString(nofStudents);
		String resopnse =addedStudents +" records has been added successfully";
		studentInfoResponseDto.setMessage(resopnse);
		studentInfoResponseDto.setCode("201");
		return studentInfoResponseDto;
	}

	private void formStudentEmtity(StudentInfoDto studentInfoDto, StudentInfo studentInfo) {
		studentInfo.setAddress(studentInfoDto.getAddress());
		studentInfo.setGrade(studentInfoDto.getGrade());
		studentInfo.setPhoneNumber(studentInfoDto.getPhoneNumber());
		studentInfo.setSection(studentInfoDto.getSection());
		studentInfo.setStudentEmail(studentInfoDto.getStudentEmail());
		studentInfo.setStudentId(studentInfoDto.getStudentId());
		studentInfo.setStudentName(studentInfoDto.getStudentName());
		studentRepository.save(studentInfo);
			}

	@Override
	public List<StudentInfoDto> fetchAllStudentDetails() {
		List<StudentInfoDto> studenInfoDtoList = new ArrayList<>();
		List<StudentInfo> StudentInfoList = studentRepository.findAll();
		if(!StudentInfoList.isEmpty()) {
			for(StudentInfo studentInfo : StudentInfoList) {
				StudentInfoDto StudentInfoDto = new StudentInfoDto();
				StudentInfoDto =formStudentInfoDto(studentInfo , StudentInfoDto);
				studenInfoDtoList.add(StudentInfoDto);
			}
			
		}
		return studenInfoDtoList;
	}

	private StudentInfoDto formStudentInfoDto(StudentInfo studentInfoDto, StudentInfoDto studentInfo) {
		studentInfo.setAddress(studentInfoDto.getAddress());
		studentInfo.setGrade(studentInfoDto.getGrade());
		studentInfo.setPhoneNumber(studentInfoDto.getPhoneNumber());
		studentInfo.setSection(studentInfoDto.getSection());
		studentInfo.setStudentEmail(studentInfoDto.getStudentEmail());
		studentInfo.setStudentId(studentInfoDto.getStudentId());
		studentInfo.setStudentName(studentInfoDto.getStudentName());		
		return studentInfo;
	}
    
	@Override
	public StudentInfoResponseDto saveStudentMarks(StudentMarksDto StudentMarksDto) {
		StudentInfoResponseDto StudentInfoResponseDto = new StudentInfoResponseDto();
		int stdId = StudentMarksDto.getStudentId();
		String msg = "";
		String code = "";
		Optional<StudentInfo> studentInfoOptional = studentRepository.findById(stdId);
		if(studentInfoOptional.isPresent()) {
			StudentMarks StudentMarks = new StudentMarks();
			StudentMarks.setStudentId(stdId);
			StudentMarks.setSemester(StudentMarksDto.getSemester());
			StudentMarks.setSession(StudentMarksDto.getSession());
			StudentMarks.setTotalSubject(StudentMarksDto.getTotalSubject());
			StudentMarksRepository.save(StudentMarks);
			msg = "record inserted successfully";
			code = "201";
			StudentInfoResponseDto = formResponse(msg ,code,StudentInfoResponseDto );
			
		}else {
			msg = "record inserted failed";
			code = "404";
			StudentInfoResponseDto = formResponse(msg ,code,StudentInfoResponseDto );
		}
		return StudentInfoResponseDto;
	}

	private StudentInfoResponseDto formResponse(String msg, String code,
			StudentInfoResponseDto studentInfoResponseDto) {
		studentInfoResponseDto.setMessage(msg);
		studentInfoResponseDto.setCode(code);
		
		return studentInfoResponseDto;
	}
   
	@Override
	public StudentWithMarksDto ftechStudentWithMarks(String studentId) {
		StudentWithMarksDto StudentWithMarksDto = new StudentWithMarksDto();
		Optional<StudentInfo> studentInfoOptional = studentRepository.findById(studentId);
		Optional<StudentMarks> StudentMarksOptional = StudentMarksRepository.findById(studentId);
		if(studentInfoOptional.isPresent() && StudentMarksOptional.isPresent() ) {
			StudentInfo StudentInfo = studentInfoOptional.get();
			StudentMarks StudentMarks = StudentMarksOptional.get();
			StudentWithMarksDto = formStudentWithMarks(StudentInfo ,StudentMarks, StudentWithMarksDto);

		}
		
		return StudentWithMarksDto;
	}

	private StudentWithMarksDto formStudentWithMarks(StudentInfo studentInfo, StudentMarks studentMarks,
			StudentWithMarksDto studentWithMarksDto) {
		studentWithMarksDto.setAddress(studentInfo.getAddress());
		studentWithMarksDto.setGrade(studentInfo.getGrade());
		studentWithMarksDto.setPhoneNumber(studentInfo.getPhoneNumber());
		studentWithMarksDto.setSection(studentInfo.getSection());
		studentWithMarksDto.setStudentEmail(studentInfo.getStudentEmail());
		studentWithMarksDto.setStudentId(studentInfo.getStudentId());
		studentWithMarksDto.setStudentName(studentInfo.getStudentName());
		StudentMarksDto StudentMarksDto = new StudentMarksDto();
		StudentMarksDto.setStudentId(studentMarks.getStudentId());
		StudentMarksDto.setSemester(StudentMarksDto.getSemester());
		StudentMarksDto.setSession(StudentMarksDto.getSession());
		StudentMarksDto.setTotalSubject(StudentMarksDto.getTotalSubject());
		studentWithMarksDto.setStudentMarksDto(StudentMarksDto);
		return studentWithMarksDto;
	}



}
