package com.lms.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	Student findByEmail(String email);
	
	@Query(value="Select * from student where sid=?1",nativeQuery = true)
	public List<Student> getStudentbyId(Long id);
	
	@Query(value="Select * from student where email=?1",nativeQuery = true)
	public List<Student> getStudentbyemail(String email);
	
	@Query(value="Select * from student where student_name=?1",nativeQuery = true)
	public List<Student> getStudentByname(String student_name);
	
	@Query(value="Select * from course where course_id=?1",nativeQuery = true)
	public List<Student> getStudentBycourseId(long course_id);
	
	@Query(value="Select * from student where date_of_birth=?1",nativeQuery = true)
	public List<Student> getStudentBydob(Date date_of_birth);
	
	@Query(value="Select * from student where sid=?1",nativeQuery = true)
	public List<Student> getdeleteById(Long id);

//	@Query(value="Select * from student where sid=?1",nativeQuery = true)
//	public void deleteById(Student student);

	
	
}