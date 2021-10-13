package com.lms.impl;

import java.sql.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.model.Student;
import com.lms.repository.StudentRepo;
import com.lms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Override
	public Student register(Student student) {
		String pass = hash(student.getPassword());
		student.setPassword(pass);
		return studentRepo.save(student);
	}

	public String hash(String password) {

		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public String Login(String email, String password) {

		Student student = studentRepo.findByEmail(email);
		if (student != null) {
			if (verifyHash(password, student.getPassword())) {
				return "log in";
			}
		}
		return "failed";
	}

	public boolean verifyHash(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}

	@Override
	public String sendEmail() {

		return null;
	}

	@Override
	public List<Student> getStudent() {
		return studentRepo.findAll();
	}

	@Override
	public List<Student> getStudentById(Long sid) {
		return studentRepo.getStudentbyId(sid);
	}

	@Override
	public List<Student> getStudentByemail(String email) {
		return studentRepo.getStudentbyemail(email);
	}

	@Override
	public List<Student> getStudentByname(String student_name) {
		return studentRepo.getStudentByname(student_name);
	}

	@Override
	public List<Student> getStudentBycourseId(Long course_id) {
		return studentRepo.getStudentBycourseId(course_id);
	}

	@Override
	public List<Student> getStudentBydob(Date date_of_birth) {
		return studentRepo.getStudentBydob(date_of_birth);
	}

	@Override
	public void update(Student student, Long sid) {
		Student s = studentRepo.findById(sid).orElseThrow(null);
		s.setName(student.getName());
		s.setAddress(student.getAddress());
		s.setMobileNo(student.getMobileNo());
		s.setDateOfBirth(student.getDateOfBirth());
		s.setEmail(student.getEmail());
		String pass = student.getPassword();
		s.setPassword(hash(pass));
		studentRepo.save(s);

	}

	@Override
	public void patch(Student student, Long sid) {
		Student s = studentRepo.findById(sid).orElseThrow(null);
		s.setName(student.getName());
		if (student.getName() != null) {
			s.setName(student.getName());
		}
		s.setAddress(student.getAddress());
		if (student.getAddress() != null) {
			s.setAddress(student.getAddress());
		}
		s.setEmail(student.getEmail());
		if (student.getEmail() != null) {
			s.setEmail(student.getEmail());
		}
		s.setDateOfBirth(student.getDateOfBirth());
		if (student.getDateOfBirth() != null) {
			s.setDateOfBirth(student.getDateOfBirth());
		}
		s.setMobileNo(student.getMobileNo());
		if (student.getMobileNo() != null) {
			s.setMobileNo(student.getMobileNo());
		}
		String password = student.getPassword();
		if (password != null) {
			s.setPassword(hash(password));
		}

		studentRepo.save(s);
	}

	@Override
	public ResponseEntity<String> delete(Long sid) {
		studentRepo.deleteById(sid);
		String delete = "Data deleted Successfully";
		return ResponseEntity.ok(delete);
	}

	public void deleteById(Long sid) {
		studentRepo.deleteById(sid);
		
	}
}