package com.lms.serviceimpl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Faculty;
import com.lms.repository.FacultyRepo;
import com.lms.service.FacultyService;

// ServiceImplementor class for Faculty

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyRepo facultyRepo;
	

	@Override
	public Faculty insert (Faculty faculty) {

		
		String pass=hash(faculty.getPassword());
		
		faculty.setPassword(pass);
		
		
		return facultyRepo.save(faculty);
	}

	public String hash(String password) {

		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public String Login(String username, String password) {
		
		Faculty faculty=facultyRepo.findname(username);
		
		if(faculty!=null) {
			
			if(verifyHash(password, faculty.getPassword())) {
				
				return "Login Successfully";
			}
		}
		
		return "Not Login";
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
	public Faculty update(Faculty faculty, Long ID) {
		
		Faculty f=facultyRepo.findById(ID).orElseThrow(null);
		f.setAddress(faculty.getAddress());
		f.setEmail(faculty.getEmail());
		f.setMobile(faculty.getMobile());
		f.setUsername(faculty.getUsername());
		f.setImage(faculty.getImage());
		
		String pass=faculty.getPassword();
		
		
		f.setPassword(hash(pass));
		
		return facultyRepo.save(f);
		
	}

	@Override
	public Faculty delete(Long ID) {

		facultyRepo.deleteById(ID);
		return null;

	}

}
