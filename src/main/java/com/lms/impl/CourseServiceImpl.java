package com.lms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Course;
import com.lms.repository.CourseRepo;
import com.lms.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;


	@Override
	public void deleteCourse(Long ID) {
		
		courseRepo.deleteById(ID);
	}

	@Override
	public void updateCourse(Course course,Long id) {
	
		Course c=courseRepo.findById(id).orElseThrow(null);
		c.setCourseName(course.getCourseName());
		c.setDuration(course.getDuration());
		c.setPrice(course.getPrice());
		
		courseRepo.save(c);
	}

	@Override
	public void add(Course course) {
		
		courseRepo.save(course);
	}

	@Override
	public List<Course> getCourse() {
		
		return courseRepo.findAll();
	}

	@Override
	public List<Course> getCourseById(Long ID) {
		
		return courseRepo.getCourseById(ID);
	}

	@Override
	public List<Course> getCourseByName(String course_name) {
		
		return courseRepo.getCourseBycourseName(course_name);
	}

}
