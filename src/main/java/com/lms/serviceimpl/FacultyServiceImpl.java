package com.lms.serviceimpl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lms.entity.Faculty;
import com.lms.helper.JwtUtil;
import com.lms.repository.FacultyRepo;
import com.lms.service.FacultyService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyRepo facultyRepo;
	
	@Autowired
    private CustomUserDetailsService customUserDetailsService;
	   private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	   @Autowired
	   JwtUtil jwtutil;
	   private String secret="java";
	    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	@Override
	public void register(Faculty faculty) {
		
		String pass=hash(faculty.getPassword());
		
		faculty.setPassword(pass);
		
//		List<Course> courses = courseRepo.findAll();
//List<Course> c = new ArrayList<>();
//		faculty.setCourses(c);

		facultyRepo.save(faculty);
//		c.stream().forEach(data -> {
//			data.setFaculty(faculty);
//		});
//		courseRepo.saveAll(courses);
	}
	
	 private String doGenerateToken(Map<String, Object> claims, String subject) {

	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
	                .signWith(SignatureAlgorithm.HS512, secret).compact();
	    } 

//	@Override
//	public void register(Faculty faculty, Course course) {
//
//		
//		String pass=hash(faculty.getPassword());
//		
//		faculty.setPassword(pass);
//		List<Course> courses = courseRepo.findAll();
//List<Course> c = new ArrayList<>();
//		faculty.setCourses(c);
//
//		facultyRepo.save(faculty);
//		c.stream().forEach(data -> {
//			data.setFaculty(faculty);
//		});
//		courseRepo.saveAll(courses);
//	}

	public String hash(String password) {

		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public String Login(String email, String password) {
		
		Faculty faculty=facultyRepo.findByUsername(email);
		
		if(faculty!=null) {
			if(verifyHash(password, faculty.getPassword())) {
				
				Map<String, Object> claims = new HashMap<>();
				String token=null;
				token=doGenerateToken(claims, faculty.getUsername());
		        
				//return "Login sucessfully"+token;	
				return token;
			}
		}
		
		return "Not login";
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

	public Faculty getFacultyIdThroughName(Faculty faculty_name) {
		
//		System.out.println(facultyRepo.getFacultyId(faculty_name));
		return facultyRepo.getFacultyId(faculty_name);
		
	}
	@Override
	public void update(Faculty faculty, Long ID) {
		
		Faculty f=facultyRepo.findById(ID).orElseThrow(null);
		f.setAddress(faculty.getAddress());
		f.setEmail(faculty.getEmail());
		f.setMobile(faculty.getMobile());
		f.setUsername(faculty.getUsername());
		
		String pass=faculty.getPassword();
		
		
		f.setPassword(hash(pass));
		
		facultyRepo.save(f);
		
	}

	@Override
	public ResponseEntity<String> delete(Long ID) {

		facultyRepo.deleteById(ID);
		String del="Data deleted Successfully";
		return ResponseEntity.ok(del);
	}



	

	



}
