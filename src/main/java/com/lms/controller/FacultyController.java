package com.lms.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/faculty")
public class FacultyController {

	@Autowired
	FacultyServiceImpl facultyserviceimpl;

	
	Logger logger=LoggerFactory.getLogger(FacultyController.class);

	
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public String login(@RequestBody Faculty faculty) {

		logger.trace("Faculty Login Successfully");
		String userName = faculty.getUsername();
		String password = faculty.getPassword(); 
		 return facultyserviceimpl.Login(userName, password);
	}
	
	
	@PostMapping()
	
	public void register(@RequestBody Faculty faculty) {
		
		logger.trace("Faculty added Successfully");
		
		facultyserviceimpl.register(faculty);
	}
	
	@GetMapping("/get")

	public List<Faculty> get() {

		logger.trace("Get the details of faculty");
		return facultyserviceimpl.getFaculty();
	}

	@GetMapping("/get/{ID}")

	public List<Faculty> getbyid(@PathVariable Long ID) {
		
		
		return facultyserviceimpl.getFacultyById(ID);
	}
	
	@GetMapping("/getByEmail/{email}")

	public List<Faculty> getbyemail(@PathVariable String email) {

		return facultyserviceimpl.getFacultyByemail(email);
	}

	@GetMapping("/getByName/{username}")

	public List<Faculty> getbyname(@PathVariable String username) {

		return facultyserviceimpl.getFacultyByname(username);
	}
	
	@PutMapping("/update/{ID}")

	public void update(@RequestBody Faculty faculty, @PathVariable Long ID) {

		logger.trace("Update Faculty");
		facultyserviceimpl.update(faculty, ID);
	}

	@DeleteMapping("/delete/{ID}")

	public ResponseEntity<String> delete(@PathVariable Long ID) {

		logger.trace("Delete Faculty");
		return facultyserviceimpl.delete(ID);
	}

}

