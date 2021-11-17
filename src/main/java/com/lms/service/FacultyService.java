package com.lms.service;

import java.util.List;
import com.lms.entity.Faculty;

// Service interface for Faculty

public interface FacultyService {

	public Faculty insert (Faculty faculty);
	
	public String Login(String email, String password);
	
	public List<Faculty> getFaculty();
	
	public List<Faculty> getFacultyById(Long id);
	
	public List<Faculty> getFacultyByemail(String email);
	
	public List<Faculty> getFacultyByname(String faculty_name);
	
	public Faculty update(Faculty faculty,Long ID);
	
	public Faculty delete(Long ID);
	
}
