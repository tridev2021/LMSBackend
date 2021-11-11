
package com.lms.controller;

//import java.net.http.HttpHeaders;
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
@CrossOrigin(origins = "*")

public class CourseController {

	@Autowired
	CourseServiceImpl courseserviceimpl;
	
	
	Logger logger=LoggerFactory.getLogger(CourseController.class);
	
	
	@GetMapping("/get")
	
	public List<Course> getAllCourses(){
		
		
		logger.trace("Get the details of course");
		return courseserviceimpl.getCourse();
	}
	
	@GetMapping("/get/{ID}")
	public List<Course> getCourseById(@PathVariable Long ID){
		
		return courseserviceimpl.getCourseById(ID);
	}
	
	@GetMapping("/getByCourse/{course}")
	public List<Course> getCourseById(@PathVariable String course){
		
		return courseserviceimpl.getCourseByName(course);
	}

	@PostMapping("")
	public void insert(@RequestBody Course course) {
		
		logger.trace("Insert new courses");
		courseserviceimpl.add(course);
	}
	
//	@GetMapping("/getId")
//	public String takeId(@RequestBody Faculty faculty){
//		
//		String facultyName=faculty.getUsername();
//		return courseserviceimpl.takeName(facultyName);
//	}
	
	@DeleteMapping("/delete/{ID}")
	
	public void delete(@PathVariable Long ID) {
		
		logger.trace("Delete course");
		courseserviceimpl.deleteCourse(ID);
	}
	

	@PutMapping("/update/{ID}")
	
	public void update(@RequestBody Course course,@PathVariable Long ID) {
		
		logger.trace("update course");
		courseserviceimpl.updateCourse(course, ID);
	}
}
