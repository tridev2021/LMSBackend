package com.lms.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.lms.model.Feedback;

public interface FeedbackService {

	public List<Feedback> getAllFeedbacks();
	
	public ResponseEntity<Map<String,String>> saveFeedback(Feedback feedback);
}
