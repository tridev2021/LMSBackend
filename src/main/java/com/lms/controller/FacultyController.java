package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Faculty;
import com.lms.impl.FacultyServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/faculty")
public class FacultyController {
	 
	 
	@Autowired
	FacultyServiceImpl facultyserviceimpl;
	
	@PostMapping("/login")
	public String login(@RequestBody Faculty faculty) {

		String email = faculty.getEmail();
		String password = faculty.getPassword();

		return facultyserviceimpl.Login(email, password);
	}

	@PostMapping("/registration")

	public void register(@RequestBody Faculty faculty) {
		facultyserviceimpl.register(faculty);
	}

	@GetMapping("/get")

	public List<Faculty> get() {

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

	@GetMapping("/getByName/{name}")

	public List<Faculty> getbyname(@PathVariable String name) {

		return facultyserviceimpl.getFacultyByname(name);
	}

	@GetMapping("/getByCourse/{course}")

	public List<Faculty> getbycourse(@PathVariable String course) {

		return facultyserviceimpl.getFacultyBycourse(course);
	}

	@GetMapping("/getBydoj/{doj}")

	public List<Faculty> getbydoj(@PathVariable String doj) {

		return facultyserviceimpl.getFacultyBydoj(doj);
	}

	@PutMapping("/update/{ID}")

	public void update(@RequestBody Faculty faculty, @PathVariable Long ID) {

		facultyserviceimpl.update(faculty, ID);
	}

	@PatchMapping("/updated/{ID}")
    public void patch (@RequestBody Faculty faculty, @PathVariable Long ID) {
	facultyserviceimpl.patch(faculty,ID);
    }

	@DeleteMapping("delete/{ID}")

	public ResponseEntity<String> delete(@PathVariable Long ID) {

		return facultyserviceimpl.delete(ID);
	}

}