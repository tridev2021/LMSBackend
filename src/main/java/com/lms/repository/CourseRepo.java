package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

	@Query(value="Select * from course where cid=?1",nativeQuery = true)
	public List<Course> getCourseById(Long ID);
	
	@Query(value="Select * from course where course_name=?1",nativeQuery = true)
	public List<Course> getCourseBycourseName(String course_name);
	
}
