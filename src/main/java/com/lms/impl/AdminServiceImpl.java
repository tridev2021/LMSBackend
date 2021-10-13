//package com.lms.impl;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.security.core.userdetails.UserDetails;
//
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.lms.model.Admin;
//import com.lms.model.Assessment;
//import com.lms.model.TechSkill;
//import com.lms.helper.JwtUtil;
////import com.lms.repository.AdminRepo;
//import com.lms.service.AdminService;
//
////import io.jsonwebtoken.Jwts;
////import io.jsonwebtoken.SignatureAlgorithm;
//import net.bytebuddy.utility.RandomString;
//
//@Service
//public class AdminServiceImpl implements AdminService{
//
////	@Autowired
//	//AdminRepo adminrepo;
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//	   private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	   @Autowired
//	   JwtUtil jwtutil;
//	   @Autowired
//	    private JavaMailSender mailSender;
//	   private String secret="java";
//	    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
////	@Override
////	public Admin register(Admin admin ,String siteURL) throws UnsupportedEncodingException, MessagingException {
////		// TODO Auto-generated method stub
////		String  password=admin.getPassword();
////		String pass=hash(password);
////	     admin.setPassword(pass);
////	     String randomCode = RandomString.make(64);
////		System.out.println("randomCode=================================");
////		System.out.println(randomCode);
////        admin.setVerificationcode(randomCode);
////	    admin.setEnabled(false);
////		adminrepo.save(admin);
////	sendVerificationEmail(admin,siteURL);
////	return admin;
////		
////	}
//	 private void sendVerificationEmail(Admin admin,String siteURL)  throws MessagingException, UnsupportedEncodingException
//	 {
//		   
////			    String toAddress = admin.getEmail();
////			    String fromAddress = "Your email address";
//			    String senderName = "RealCoderZ";
//			    String subject = "Please verify your registration";
//			    String mailContent = "Dear lalit,<br>";
//			           mailContent += "<p>Please click the link below to verify your registration:</p>";
//			           String verifyURL = "http://localhost:8084"+ "/api/verify?code=" + admin.getVerificationcode();
////			            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
////			            + "Thank you,<br>"
////			            + "Your company name.";
////			           mailContent += "<h3><a =\"href=" +verifyURL +"\" >VERIFY</a></h3>";
//			           mailContent += "<h3><a href=\"" +verifyURL +"\" >VERIFY</a></h3>";
//			           mailContent +="<p> Thank you<br> The RealCodez</p>";
//			    MimeMessage message = mailSender.createMimeMessage();
//			    MimeMessageHelper helper = new MimeMessageHelper(message);
//			     
//			    helper.setFrom("lalit15132130@gmail.com", senderName);
//			    helper.setTo(admin.getEmail());
//			    helper.setSubject(subject);
//			     
////			    content = content.replace("[[name]]", admin.getUsername());
////			    String verifyURL = siteURL + "/verify?code=" + admin.getVerificationcode();
////			     
////			    content = content.replace("[[URL]]", verifyURL);
// helper.setText(mailContent, true);
//			     
//			    mailSender.send(message);
//		
//	}
//	private String doGenerateToken(Map<String, Object> claims, String subject) {
//
//	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//	                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//	                .signWith(SignatureAlgorithm.HS512, secret).compact();
//	    }
//public String hash(String password) {
//		
//        return BCrypt.hashpw(password, BCrypt.gensalt());
//    }
//@Override
//public String Login(String username, String password) {
//	// TODO Auto-generated method stub
//	System.out.println(username);
//   Admin admin=adminrepo.findByUsername(username);
//   System.out.println(admin);
//	
//	if(admin!=null)
//	{
//		//if(verifyHash( password,admin.getPassword())) {
//			//if(password==admin.getPassword()) {
//		if(passwordEncoder.matches(password, admin.getPassword()))
//		{
//			//UserDetails userDetails = (UserDetails) admin;
//			Map<String, Object> claims = new HashMap<>();
//			String token=null;
//			token=doGenerateToken(claims, admin.getUsername());
//	        
//			//return "Login sucessfully"+token;	
//			return token;
//		}
//				
//	}
//	
//return "not login";
//
//}
//
//	 public boolean verifyHash(String password, String hash) {
//	        return BCrypt.checkpw(password, hash);
//	    }
//	@Override
//	public ResponseEntity<Map<String,String>> delete( Long ID) {
//		// TODO Auto-generated method stub
//		Map<String,String> response=new HashMap<>();
//		response.put("Data", "Delete data Successfully");
//	    adminrepo.deleteById(ID);
//		return ResponseEntity.ok(response);
//	}
//	@Override
//	public List<Admin> getdata() {
//		// TODO Auto-generated method stub
//		return adminrepo.findAll();
//	}
//	@Override
//	public ResponseEntity<Admin> update(Admin admin, Long tId) {
//		// TODO Auto-generated method stub
//		Admin adm=adminrepo.findById(tId).orElseThrow(null);
//		   System.out.println(adm);
//		   adm.setEmail(admin.getEmail());
//		  adm.setUsername(admin.getUsername());
//		   Admin adms=adminrepo.save(adm);
//		   System.out.println(adms);
//		 return ResponseEntity.ok(adms);
//	}
//	@Override
//	public Optional<Admin> findById(Long ID) {
//		// TODO Auto-generated method stub
//		return adminrepo.findById(ID);
//	}
//	public boolean verify(String verificationCode) {
//	    Admin admin = adminrepo.findByVerificationCode(verificationCode);
//	     
//	    if (admin == null || admin.isEnabled()) {
//	        return false;
//	    } else {
////	        admin.setVerificationcode(null);
////	        admin.setEnabled(true);
//	    	
////	        adminrepo.save(admin);
//	         adminrepo.enabled(admin.getID());
//	        return true;
//	    }
//	     
//	}
//	@Override
//	public com.lms.service.Admin register(com.lms.service.Admin admin, String siteURL)
//			throws UnsupportedEncodingException, MessagingException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public ResponseEntity<com.lms.service.Admin> update(com.lms.service.Admin admin, Long tId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//
//
//	
//	
//}
