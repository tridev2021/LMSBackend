package com.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.StudyBatch;
import com.lms.impl.StudyBatchServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/studybatch")
public class StudyBatchController {

	@Autowired
	private StudyBatchServiceImpl serviceImp;
	
	@GetMapping("/alldata")
	public List<StudyBatch> getAllStudyBatch(){
		return serviceImp.getStudyBatch();
	}
	
	@GetMapping("/schedule/{ID}")
	public Optional<StudyBatch> getDataByID(@PathVariable Long ID){
		return (Optional<StudyBatch>) serviceImp.findById(ID);
       }
	
	@PostMapping("/insert")
	public void insert(@RequestBody StudyBatch sb) {
		serviceImp.add(sb);
	}
	
	@PutMapping("/updateing/{bid}")
	public void update(@RequestBody StudyBatch sb, @PathVariable Long bid) {
		serviceImp.updateStudyBatch(sb, bid);
	}
	
	@DeleteMapping("/delete/{bid}")
	public void delete( @PathVariable long bid ) {
		serviceImp.deleteStudyBatch( bid);
	}
}