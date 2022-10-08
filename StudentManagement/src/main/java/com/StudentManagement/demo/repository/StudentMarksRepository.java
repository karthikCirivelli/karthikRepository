package com.StudentManagement.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagement.demo.enity.StudentMarks;
@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {

	Optional<StudentMarks> findById(String studentId);

}
