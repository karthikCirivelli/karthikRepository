package com.StudentManagement.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagement.demo.enity.StudentInfo;

public interface StudentRepository extends JpaRepository<StudentInfo, Integer> {

	Optional<StudentInfo> findById(String studentId);

}
