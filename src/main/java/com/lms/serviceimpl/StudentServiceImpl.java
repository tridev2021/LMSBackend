package com.lms.serviceimpl;



import java.sql.Date;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.entity.Student;
import com.lms.repository.StudentRepo;
import com.lms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo studentRepo;

	@Override
	public void register(Student student) {
		String pass= hash(student.getPassword());
		student.setPassword(pass);
		studentRepo.save(student);
	}
	
    public String hash(String password) {
		
		return BCrypt.hashpw(password, BCrypt.gensalt());
   	}
 
	@Override
	public String Login(String email, String password) {
		Student student=studentRepo.findByEmail(email);
		
		
		if(student!=null) {
			if(verifyHash(password, student.getPassword())) {
				
				return "Login Successfully";
			}
		}
		
		return "Failed to Login";
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
		s.setUsername(student.getUsername());
		s.setAddress(student.getAddress());
	    s.setMobileno(student.getMobileno());
	    s.setDateofbirth(student.getDateofbirth());
	    s.setEmail(student.getEmail());
	    String pass= student.getPassword();
	    s.setPassword(hash(pass));
	    studentRepo.save(s);
	
	}

	@Override
	public void patch(Student student, Long sid) {
	Student s = studentRepo.findById(sid).orElseThrow(null);
	s.setUsername(student.getUsername());
	if(student.getUsername() !=null) {
		s.setUsername(student.getUsername());
	}
	    
		studentRepo.save(s);
	}

	@Override
	public ResponseEntity<String> delete(Long sid) {
		studentRepo.deleteById(sid);
		String delete = "Data deleted Successfully";
		return ResponseEntity.ok(delete);
	}

		
}