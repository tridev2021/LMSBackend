package com.lms.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lms.entity.Faculty;

public interface FacultyService {

	public void register(Faculty faculty);
	
	public String Login(String email, String password);
	
	public List<Faculty> getFaculty();
	
	public List<Faculty> getFacultyById(Long id);
	
	public List<Faculty> getFacultyByemail(String email);
	
	public List<Faculty> getFacultyByname(String faculty_name);
	
	public void update(Faculty faculty,Long ID);
	
	public ResponseEntity<String> delete(Long ID);
}

