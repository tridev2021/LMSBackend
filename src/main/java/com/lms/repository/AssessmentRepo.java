package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Assessment;

public interface AssessmentRepo extends JpaRepository<Assessment, Long>{
	
	

}
