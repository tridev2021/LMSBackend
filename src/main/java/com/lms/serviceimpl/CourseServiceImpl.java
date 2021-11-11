package com.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Course;
import com.lms.repository.CourseRepo;
import com.lms.service.CourseService;

@Service
public class CourseServiceImpl {

	@Autowired
	private CourseRepo courseRepo;
	

	
	public void deleteCourse(Long ID) {
		
		courseRepo.deleteById(ID);
	}


	public void updateCourse(Course course,Long id) {
	
		Course c=courseRepo.findById(id).orElseThrow(null);
		c.setCoursename(course.getCoursename());
		c.setDuration(course.getDuration());
		c.setPrice(course.getPrice());
		courseRepo.save(c);
	}

	public void add(Course course) {
		
		//String id= courseRepo.getid(course.getName());
//		course.se
		//course.getFaculty().getFID();
//		System.out.println(course.getFid());
	courseRepo.save(course);
		
		
	}


	public List<Course> getCourse() {
		
		return courseRepo.findAll();
	}

	
	public List<Course> getCourseById(Long ID) {
		
		return courseRepo.getCourseById(ID);
	}

	
	public List<Course> getCourseByName(String course_name) {
		
		return courseRepo.getCourseBycourseName(course_name);
	}

	
//	public String takeName(String facultyName) {
//		
//		
//	    return courseRepo.getid(facultyName);
//	}
//
//	public String facultyName(String facultyName) {
//		
//		return takeName(facultyName);
//	}


}

