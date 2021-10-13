package com.lms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lms.model.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Long> {
	
	Faculty findByEmail(String email);
	
	@Query(value="Select * from faculty where fid=?1",nativeQuery = true)
	public List<Faculty> getFacultybyId(Long id);
	
	@Query(value="Select * from faculty where email=?1",nativeQuery = true)
	public List<Faculty> getFacultybyemail(String email);
	
	@Query(value="Select * from faculty where faculty_name=?1",nativeQuery = true)
	public List<Faculty> getFacultyByname(String faculty_name);
	
	@Query(value="Select * from faculty where course_name=?1",nativeQuery = true)
	public List<Faculty> getFacultyBycourse(String course_name);
	
	@Query(value="Select * from faculty where date_of_joining=?1",nativeQuery = true)
	public List<Faculty> getFacultyBydoj(String date_of_joining);
	
//	@Query(value="Select (f.fid,f.course_name) from faculty f",nativeQuery = true)
//	public List<Faculty> getFacultyBy();
}
