package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.impl.QusetionUploadServiceImpl;
import com.lms.model.QuestionUpload;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/questions")
public class QuestionUploadController {

	@Autowired
	QusetionUploadServiceImpl questionUploadServiceImpl;
	
	@GetMapping("/getall")
	 public List<QuestionUpload> getQuestionUpload(){
		return questionUploadServiceImpl.getQuestionUpload();
		 
	 }
	
	@PostMapping("/insertQuestion")
	public void insert(@RequestBody QuestionUpload qu) {
		questionUploadServiceImpl.add(qu);
	}
}
