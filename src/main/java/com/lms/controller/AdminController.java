package com.lms.controller;

/*

@Author : Lalit

*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Admin;
import com.lms.serviceimpl.AdminServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AdminController {
	
	
	@Autowired
	private  AdminServiceImpl adminserviceimpl;
	
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/Register")
	
	public Admin saveregister(@RequestBody Admin admin)
	
	{
		System.out.println(admin);
		
		logger.trace("Register working properly");

		return adminserviceimpl.insert(admin); 

	}

     @PostMapping("/login")
	public String fetch(@RequestBody Admin admin)
	{

    	 String username=admin.getUsername();
    	 String password=admin.getPassword();
    	 
        return adminserviceimpl.Login(username, password);

	}
	@GetMapping("/admin")
	public List<Admin> getsdata()
	{
		return adminserviceimpl.getdata();
		
	} 

//	@CrossOrigin(origins = "*")
     @DeleteMapping("/admin/{ID}")
     public ResponseEntity<Map<String,String>> deletedata(@PathVariable Long ID)

     {
    	 logger.trace("Delete data working properly");
		return adminserviceimpl.delete(ID);
    	 
     }
     @PutMapping("/edit/{tId}")
 	public ResponseEntity <Map<String,String>> updatedata(@RequestBody Admin admin,@PathVariable Long tId)
 	{
 		Map<String ,String> response=new HashMap<>();
 		adminserviceimpl.update(admin, tId);
 		response.put("Data", "Update sucessfully");
 		return ResponseEntity.ok(response);
 		
 	}
   @GetMapping("/admin/{ID}")
 	public Optional<Admin> getAdmin(@PathVariable("ID") Long ID){
 		return adminserviceimpl.findById((ID));
 	}

     
}
