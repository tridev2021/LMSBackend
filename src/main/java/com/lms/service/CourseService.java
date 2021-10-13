package com.lms.service;

import java.util.List;

import com.lms.model.Course;

public interface CourseService {

	public List<Course> getCourse();
	
	public List<Course> getCourseById(Long ID);
	
	public List<Course> getCourseByName(String course_name);
	
	public void deleteCourse(Long ID);
	
	public void updateCourse(Course course,Long id);
	
	public void add(Course course);
	
}
