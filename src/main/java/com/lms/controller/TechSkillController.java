package com.lms.controller;

/*

@Author : Mayank

*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.TechSkill;
import com.lms.serviceimpl.TechSkillImpl;

@RestController
@RequestMapping("tech")
public class TechSkillController {
    
	@Autowired
	TechSkillImpl techskillimpl;
	Logger logger=LoggerFactory.getLogger(AdminController.class);

	// Method for inserting the techskills
	
	@PostMapping("/insertdata")
	public TechSkill insert(@RequestBody TechSkill techskill)
	{
		return techskillimpl.insertdata(techskill);
	}
	
	// Method for getting the details of techskill
	
	@GetMapping("/getdata")
	public List<TechSkill> fetch()
	{
		return techskillimpl.getdata();
		
	}
	
	// Method for updating the details of techskills
	
	@PutMapping("/update/{tId}")
	public ResponseEntity <Map<String,String>> updatedata(@RequestBody TechSkill techskill,@PathVariable Long tId)
	{
		Map<String ,String> response=new HashMap<>();
		techskillimpl.update(techskill, tId);
		response.put("Data", "Update sucessfully");
		return ResponseEntity.ok(response);
		
	}
	

	
	
	
}
