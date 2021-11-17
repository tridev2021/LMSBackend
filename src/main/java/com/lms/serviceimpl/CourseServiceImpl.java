package com.lms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Course;
import com.lms.entity.Faculty;
import com.lms.repository.CourseRepo;
import com.lms.repository.FacultyRepo;

//ServiceImplementor class for Course

@Service
public class CourseServiceImpl {

	@Autowired
	private CourseRepo courseRepo;
	
   @Autowired
   FacultyRepo facultyRepo;
	
	public void deleteCourse(Long ID) {
		
		courseRepo.deleteById(ID);
	}


	public void updateCourse(Course course,Long id) {
	
		Course c=courseRepo.findById(id).orElseThrow(null);
		c.setCoursename(course.getCoursename());
		c.setDuration(course.getDuration());
		c.setPrice(course.getPrice());
		
		if(course.getFaculty()!=null) {
		Faculty f=facultyRepo.findById(c.getFaculty().getFID()).orElseThrow(null);
		f.setAddress(course.getFaculty().getAddress());
		f.setEmail(course.getFaculty().getEmail());
		f.setImage(course.getFaculty().getImage());
		f.setMobile(course.getFaculty().getMobile());
		f.setPassword(course.getFaculty().getPassword());
		f.setUsername(course.getFaculty().getUsername());
		facultyRepo.save(f);
		}
		
		courseRepo.save(c);
		
	}

	public Course add(Course course) {
		
	return courseRepo.save(course);
		
		
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


}

