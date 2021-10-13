package com.lms.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.model.Feedback;
import com.lms.repository.FeedbackRepo;
import com.lms.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackRepo feedbackRepo;
	
	@Override
	public List<Feedback> getAllFeedbacks() {
		
		return feedbackRepo.findAll();
	}

	@Override
	public ResponseEntity<Map<String, String>> saveFeedback(Feedback feedback) {
		
		Map<String,String> response=new HashMap<>();
		feedbackRepo.save(feedback);
		response.put("Feedback Saved", "Successfully");
		return ResponseEntity.ok(response);
		
	}


}
