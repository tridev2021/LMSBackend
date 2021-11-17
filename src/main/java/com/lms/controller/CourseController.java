package com.lms.controller;

/*

@Author : Mayank

*/


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.lms.entity.Course;
import com.lms.serviceimpl.CourseServiceImpl;

@RestController
@RequestMapping("api/course")
@CrossOrigin(origins = "http://localhost:3000")

public class CourseController {

	@Autowired
	CourseServiceImpl courseserviceimpl;
	
	
	Logger logger=LoggerFactory.getLogger(CourseController.class);
	
	// Method for Getting details of courses
	
	@GetMapping()

	public List<Course> getAllCourses(){
		
		
		logger.trace("Get the details of course");
		return courseserviceimpl.getCourse();
	}
	
	// Method for Getting details of courses of particular Id
	
	@GetMapping("/get/{ID}")
	public List<Course> getCourseById(@PathVariable Long ID){
		
		return courseserviceimpl.getCourseById(ID);
	}
	
	// Method for Getting details of courses of particular Course
	
	@GetMapping("/getByCourse/{course}")
	public List<Course> getCourseById(@PathVariable String course){
		
		return courseserviceimpl.getCourseByName(course);
	}

	// Method for adding courses
	
	@PostMapping()
	public Course insert(@RequestBody Course course) {
		
		logger.trace("Insert new courses");
		return courseserviceimpl.add(course);
	}
	
	// Method for deleting details of courses of particular Id
	
	@DeleteMapping("/delete/{ID}")
	
	public void delete(@PathVariable Long ID) {
		
		logger.trace("Delete course");
		courseserviceimpl.deleteCourse(ID);
	}
	
	// Method for updating details of courses of particular Id
	
	@PutMapping("/update/{ID}")
	
	public void update(@RequestBody Course course,@PathVariable Long ID) {
		
		logger.trace("update course");
		courseserviceimpl.updateCourse(course, ID);
	}
}
