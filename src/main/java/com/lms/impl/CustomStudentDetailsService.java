//package com.lms.serviceimpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.lms.entity.CustomStudentDetails;
//import com.lms.entity.CustomUserDetails;
//import com.lms.entity.Student;
//import com.lms.repository.StudentRepo;
//@Service
//public class CustomStudentDetailsService implements UserDetailsService{
//	
//	@Autowired
//    StudentRepo studentrepo;
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		 final Student student = this.studentrepo.findByUsername(userName);
//
//	        if (student == null) {
//	            throw new UsernameNotFoundException("Student not found !!");
//	        } else {
//	            return new CustomStudentDetails(student);
//	        }
//		
//	}
//
//}
