package com.lms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.lms.model.Grade;
import com.lms.impl.GradeServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/grade")
public class GradeController {
	
	@Autowired
	private GradeServiceImpl GradeServiceImp;

	@GetMapping("/allgrade")
	public ResponseEntity<List<Grade>> getAllGrade(){
		return new ResponseEntity<List<Grade>>(GradeServiceImp.getGrade(), HttpStatus.OK );
	}
	
	@GetMapping("/gradebyid/{ID}")
	public ResponseEntity<Grade> getDataByID(@PathVariable Long ID){
		Grade grade = GradeServiceImp.findById(ID).orElse(null);
		return ResponseEntity.ok(grade);
		}
		
	@PostMapping("/insertGrade")
	public ResponseEntity<Map<String,String>> insert(@RequestBody Grade g) {
		GradeServiceImp.insert(g);
		Map<String, String>response = new HashMap<>();
		response.put("Data", " Grade inserted succesfully");
		return ResponseEntity.ok(response);
		}
	
	@PutMapping("/updateGrade/{gid}")
	public ResponseEntity<Map<String,String>> update(@RequestBody Grade g, @PathVariable Long gid) {
		GradeServiceImp.updateGrade(g, gid);
		Map<String, String>response = new HashMap<>();
		response.put("Data", " Grade updated succesfully");
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/delete/{gid}")
	public ResponseEntity<Map<String,String>> delete( @PathVariable long gid ) {
		GradeServiceImp.deleteGrade( gid);
		Map<String, String>response = new HashMap<>();
		response.put("Data", " Grade deleted succesfully");
		return ResponseEntity.ok(response);	
	}
	
}