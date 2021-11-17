package com.lms.controller;

/*

 @Author : Mayank
 
 */


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Faculty;
import com.lms.serviceimpl.FacultyServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/faculty")

public class FacultyController {

	@Autowired
	FacultyServiceImpl facultyserviceimpl;
	
	Logger logger=LoggerFactory.getLogger(CourseController.class);

	// Method for Faculty Login
	
	@PostMapping("/login")
	public String login(@RequestBody Faculty faculty) {

		logger.trace("Faculty Login Successfully");
		String username = faculty.getUsername();
		String password = faculty.getPassword(); 
		 return facultyserviceimpl.Login(username, password);
	}

	// Method for Faculty Registration
	
	@PostMapping()

	public Faculty register(@RequestBody Faculty faculty)
 {

		logger.trace("Faculty added Successfully");
		return facultyserviceimpl.insert(faculty);

	}

	// Method for Getting details of Faculty
	
	@GetMapping("/get")

	public List<Faculty> get() {

		logger.trace("Get the details of faculty");
		return facultyserviceimpl.getFaculty();
	}

	// Method for Getting details of Faculty of particular Id
	
	@GetMapping("/get/{ID}")

	public List<Faculty> getbyid(@PathVariable Long ID) {
		
		
		return facultyserviceimpl.getFacultyById(ID);
	}
	
	// Method for Getting details of Faculty of particular email
	
	@GetMapping("/getByEmail/{email}")

	public List<Faculty> getbyemail(@PathVariable String email) {

		return facultyserviceimpl.getFacultyByemail(email);
	}
	
	// Method for Getting details of Faculty of particular name
	
	@GetMapping("/getByName/{name}")

	public List<Faculty> getbyname(@PathVariable String name) {

		return facultyserviceimpl.getFacultyByname(name);
	}
	
	
	// Method for updating details of Faculty of particular Id
	
	@PutMapping("/update/{ID}")

	public Faculty update(@RequestBody Faculty faculty, @PathVariable Long ID) {

		logger.trace("Update Faculty");
		return facultyserviceimpl.update(faculty, ID);
	}

	// Method for delete details of Faculty of particular Id
	
	@DeleteMapping("/delete/{ID}")

	public Faculty delete(@PathVariable Long ID) {

		logger.trace("Delete Faculty");
		return facultyserviceimpl.delete(ID);
	}
		   
	   }

