package com.lms.service;

import java.util.List;

import com.lms.model.QuestionUpload;

public interface QuestionUploadService {

	 public List<QuestionUpload> getQuestionUpload();
	   
	public void add(QuestionUpload qu) ;
}