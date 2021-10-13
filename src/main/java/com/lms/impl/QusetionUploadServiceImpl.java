package com.lms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.QuestionUpload;
import com.lms.repository.QuestionUploadRepo;
import com.lms.service.QuestionUploadService;

@Service
public class QusetionUploadServiceImpl implements QuestionUploadService {

	@Autowired
	QuestionUploadRepo questionUploadRepo;
	
	 public List<QuestionUpload> getQuestionUpload(){
		 return questionUploadRepo.findAll();
	 }
	
	@Override
	public void add(QuestionUpload qu) {
		questionUploadRepo.save(qu);
	}
}