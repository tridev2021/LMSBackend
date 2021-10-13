//package com.lms.service;
//
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.mail.MessagingException;
//
//import org.springframework.http.ResponseEntity;
//
//import com.lms.entity.Admin;
//import com.lms.entity.TechSkill;
//
//public interface AdminService {
//	public List<Admin> getdata();
//	public Admin register(Admin admin,String siteURL) throws UnsupportedEncodingException, MessagingException;
//	public String Login(String username,String password);
//	public ResponseEntity<Map<String,String>> delete(Long ID);
//	public ResponseEntity<Admin> update(Admin admin, Long tId);
//	public  Optional<Admin> findById(Long ID);
//
//	//public ResponseEntity<Admin> update(Admin admin,Long ID);
//	//public ResponseEntity<Admin> updatedata(Admin admin,Long Id);
//
//
//}
