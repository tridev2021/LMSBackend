package com.lms.controller;

import java.util.List;

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

import com.lms.model.Course;
import com.lms.impl.CourseServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/course")
public class CourseController {

	@Autowired
	CourseServiceImpl courseserviceimpl;
	
	@GetMapping("/get")
	public List<Course> getAllCourses(){
		
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
	
	@PostMapping("/insert")
	public void insert(@RequestBody Course course) {
		
		courseserviceimpl.add(course);
	}
	
	@DeleteMapping("/delete/{ID}")
	
	public void delete(@PathVariable Long ID) {
		
		courseserviceimpl.deleteCourse(ID);
	}
	
	@PutMapping("/update/{ID}")
	
	public void update(@RequestBody Course course,@PathVariable Long ID) {
		
		courseserviceimpl.updateCourse(course, ID);
	}
}
