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

import com.lms.model.Student;
import com.lms.impl.StudentServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/student")
public class StudentController {
	
	@Autowired
	StudentServiceImpl serviceImpl;

	@PostMapping("/registration")
	public Student register(@RequestBody Student student) {
		return serviceImpl.register(student);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Student student) {

		String email = student.getEmail();
		String password = student.getPassword();

		return serviceImpl.Login(email, password);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> get(){
		return serviceImpl.getStudent();
	}
	
	@RequestMapping("/sendEmail")
	@PostMapping("/sendEmail")
	 public String sendEmail() {
	      return "Email sent successfully";
	   }   
	
	@GetMapping("/getByEmail/{email}")

	public List<Student> getbyemail(@PathVariable String email) {

		return serviceImpl.getStudentByemail(email);
	}
	
	@GetMapping("/fetchingStudentby/{ID}")
    public List<Student> getbyid(@PathVariable Long ID) {

		return serviceImpl.getStudentById(ID);
	}
	
	@PutMapping("/updatingStudent/{ID}")
    public void update(@RequestBody Student student, @PathVariable Long ID) {

		serviceImpl.update(student, ID);
	}
	
	@PatchMapping("/updated/{ID}")
	public void patch(@RequestBody Student student, @PathVariable Long ID) {

		serviceImpl.patch(student, ID);
	}

	@DeleteMapping("delete/{ID}")
    public ResponseEntity<String> delete(@PathVariable Long ID) {

		return serviceImpl.delete(ID);
	}
	
}