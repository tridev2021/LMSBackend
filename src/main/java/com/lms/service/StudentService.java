package com.lms.service;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lms.model.Student;

public interface StudentService {

	public Student register(Student student);

	public String Login(String email, String password);

	public String sendEmail();
	
	public List<Student> getStudent();

	public List<Student> getStudentById(Long sid);

	public List<Student> getStudentByemail(String email);

	public List<Student> getStudentByname(String student_name);

	public List<Student> getStudentBycourseId(Long course_id);

	public List<Student> getStudentBydob(Date date_of_birth);

	public void update(Student student, Long sid);

	public void patch(Student student, Long sid);

	public ResponseEntity<String> delete(Long sid);

}