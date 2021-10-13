package com.lms.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lms.model.Faculty;
import com.lms.repository.FacultyRepo;
import com.lms.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyRepo facultyRepo;
	

	@Override
	public void register(Faculty faculty) {

		
		String pass=hash(faculty.getPassword());
		
		faculty.setPassword(pass);
		
		
		facultyRepo.save(faculty);
	}

	public String hash(String password) {

		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public String Login(String email, String password) {
		
		Faculty faculty=facultyRepo.findByEmail(email);
		
		if(faculty!=null) {
			if(verifyHash(password, faculty.getPassword())) {
				
				return "Login Successfully";
			}
		}
		
		return "Failed to Login";
	}
	
	public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

	
	@Override
	public List<Faculty> getFaculty() {
		
		return facultyRepo.findAll();
	}
	
	@Override 
	public List<Faculty> getFacultyById(Long id) {
		
		return facultyRepo.getFacultybyId(id);
	}
	
	@Override
	public List<Faculty> getFacultyByemail(String email) {
		
		return facultyRepo.getFacultybyemail(email);
	}
	
	@Override
	public List<Faculty> getFacultyByname(String faculty_name) {

		return facultyRepo.getFacultyByname(faculty_name);
	}
	
	@Override
	public List<Faculty> getFacultyBycourse(String course_name) {
		
		return facultyRepo.getFacultyBycourse(course_name);
	}
	
	@Override
	public List<Faculty> getFacultyBydoj(String date_of_joining) {
		
		return facultyRepo.getFacultyBydoj(date_of_joining);
	}

	@Override
	public void update(Faculty faculty, Long ID) {
		
		Faculty f=facultyRepo.findById(ID).orElseThrow(null);
		f.setEmail(faculty.getEmail());
		f.setMobile(faculty.getMobile());
		f.setFacultyName(faculty.getFacultyName());
		f.setAddress(faculty.getAddress());
		
		String pass=faculty.getPassword();
		
		f.setPassword(hash(pass));
		
		facultyRepo.save(f);
		
	}
	@Override
	public void patch(@RequestBody Faculty faculty, @PathVariable Long ID ) {
		Faculty f=facultyRepo.findById(ID).orElseThrow(null);
	
		f.setMobile(faculty.getMobile());
		if(faculty.getMobile() !=null) {
			f.setMobile(faculty.getMobile());
		}
		f.setFacultyName(faculty.getFacultyName());
		if(faculty.getFacultyName() !=null) {
			f.setFacultyName(faculty.getFacultyName());
		}
		f.setAddress(faculty.getAddress());
		if(faculty.getAddress() !=null) {
			f.setAddress(faculty.getAddress());
		}
		if(faculty.getEmail() !=null) {
			f.setEmail(faculty.getEmail());
		}
		String pass=faculty.getPassword();
		 if(pass !=null) {
				f.setPassword(hash(pass));
		 }
		
		facultyRepo.save(f);

	}

	@Override
	public ResponseEntity<String> delete(Long ID) {

		facultyRepo.deleteById(ID);
		String del="Data deleted Successfully";
		return ResponseEntity.ok(del);
	}
}