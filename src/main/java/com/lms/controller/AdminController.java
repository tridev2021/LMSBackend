//package com.lms.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.mail.MessagingException;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.method.P;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lms.model.Admin;
//import com.lms.model.TechSkill;
//import com.lms.impl.AdminServiceImpl;
////@CrossOrigin( "http://localhost:3000")
//
//import net.bytebuddy.utility.RandomString;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api")
//public class AdminController {
//	
//	
//	@Autowired
//	private  AdminServiceImpl adminserviceimpl;
//	
//	
//	Logger logger=LoggerFactory.getLogger(AdminController.class);
//
//	@PostMapping("/Register")
//	
//	public String saveregister(@RequestBody Admin admin,Model model,HttpServletRequest request) throws UnsupportedEncodingException, MessagingException
//	
//	{
//		System.out.println(admin);
//		
//		logger.trace("Register working properly");
//
//		adminserviceimpl.register(admin, null); 
//		String siteURL = Utility.getSiteURL(request);
//		model.addAttribute("pageTitle","Registration Succeeded!");
//      return "register/register_success"; 
//	}
//	//@CrossOrigin(origins = "http://localhost:3000")
//	@CrossOrigin(origins = "*")
//     @PostMapping("/login")
//	public ResponseEntity <Map<String,String>> fetch(@RequestBody Admin admin)
//	{
//		String username=admin.getUsername();
//         String password=admin.getPassword();
//         String token=adminserviceimpl.Login(username, password);
//		Map<String ,String> response=new HashMap<>();
//		
//		
//		response.put("token",token);
//		response.put("Login","login successfully");
//		return ResponseEntity.ok(response);
//		
//	}
//     //@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping("/admin")
//	public List<Admin> getsdata()
//	{
//		return adminserviceimpl.getdata();
//		
//	}
//
////	@CrossOrigin(origins = "*")
//     @DeleteMapping("/admin/{ID}")
//     public ResponseEntity<Map<String,String>> deletedata(@PathVariable Long ID)
//
//     {
//    	 logger.trace("Delete data working properly");
//		return adminserviceimpl.delete(ID);
//    	 
//     }
//     @PutMapping("/edit/{tId}")
// 	public ResponseEntity <Map<String,String>> updatedata(@RequestBody Admin admin,@PathVariable Long tId)
// 	{
// 		Map<String ,String> response=new HashMap<>();
// 		adminserviceimpl.update(admin, tId);
// 		response.put("Data", "Update sucessfully");
// 		return ResponseEntity.ok(response);
// 		
// 	}
//   @GetMapping("/admin/{ID}")
// 	public Optional<Admin> getAdmin(@PathVariable("ID") Long ID){
// 		return adminserviceimpl.findById((ID));
// 	}
//   @GetMapping("/verify")
//   public String verifyAccount(@Param("code") String code,Model model) {
//	   boolean verified = adminserviceimpl.verify(code);
//	   String pageTitle = verified ? "Verification Succeeded" : "verification Failed";
//	   model.addAttribute("pageTitle", pageTitle);
//	   return "register/" + (verified ? "verify_success" : "verify_fall");
////       if (adminserviceimpl.verify(code)) {
////           return "verify_success";
////       } else {
////           return "verify_fail";
////       }
//	   
//   }
//
//     
//}
