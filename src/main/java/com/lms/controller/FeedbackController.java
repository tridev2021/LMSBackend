package com.lms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Feedback;
import com.lms.impl.FeedbackServiceImpl;

@RestController
@RequestMapping("api/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
	
	@Autowired
	FeedbackServiceImpl feedBackServiceImpl;
	
	@GetMapping()
	public List<Feedback> getFeedbacks(){
		
		return feedBackServiceImpl.getAllFeedbacks();
	}
	
	@PostMapping()
		public ResponseEntity<Map<String,String>> saveFeedbacks(@RequestBody Feedback feedback){
			
			return feedBackServiceImpl.saveFeedback(feedback);
		}
	

}
