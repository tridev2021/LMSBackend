package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.entity.Course;
import com.lms.entity.Faculty;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

	@Query(value="Select * from course where cid=?1",nativeQuery = true)
	public List<Course> getCourseById(Long ID);
	
	@Query(value="Select * from course where course_name=?1",nativeQuery = true)
	public List<Course> getCourseBycourseName(String course_name);
	
//	@Query(value="Select fid from faculty where faculty_name=?1", nativeQuery = true)
//	public String getid(String name);
	
//	public void findByFaculty(Faculty faculty);
	
}


