//package com.lms.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lms.entity.Assessment;
//import com.lms.serviceimpl.AssessmentServiceImpl;
//
//@RestController
//@RequestMapping("avi")
//public class AssessmentController {
//	
//	@Autowired
//AssessmentServiceImpl assessmentserviceimpl;
//	Logger logger=LoggerFactory.getLogger(AssessmentController.class);
//	
//	@GetMapping("/getdata")
//	public List<Assessment> fetchdata()
//	{
//		
//		logger.trace("Data fetch from database in Assessment api working properly");
//		return assessmentserviceimpl.getdata();
//		
//	}
// 
//	@PostMapping("/insert")
//	
//	public ResponseEntity<Map<String, String>> insert(@RequestBody Assessment assessment )
//	{
//		logger.trace("Register in assessment working properly");
//		Map<String,String> response=new HashMap<>();
//		assessmentserviceimpl.insertdata(assessment);
//		response.put("Data", "Insert data Sucessfully in database");
//		return ResponseEntity.ok(response);
//		
//	}
//	
//	@PutMapping("/update/{AId}")
//	public ResponseEntity<Map<String,String>> update(@RequestBody Assessment assessment,@PathVariable Long AId)
//	{
//		logger.trace("Update in assessement api working properly");
//		Map<String,String> response=new HashMap<>();
//		assessmentserviceimpl.updatedata(assessment, AId);
//		response.put("Data", "Update data suceesfully in table ");
//		return ResponseEntity.ok(response);
//		
//	} 
//	
//	@DeleteMapping("/delete/{AId}")
//	public ResponseEntity<Map<String,String>> delete(@RequestBody Assessment assessment,@PathVariable Long AId)
//	{
//		logger.trace("Delete data in assessment working properly");
//		//Map<String,String> response=new HashMap<>();
//		return assessmentserviceimpl.deletedata(assessment, AId);
//		//response.put("Data","Delete data from the table");
//		//return ResponseEntity.ok(response);
//		
//	}
//	
//	
//	
//
//}
