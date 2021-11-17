package com.lms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.entity.Faculty;

// Repository interface for Faculty

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Long> {
	
//	Faculty findByEmail(String email);
	
	@Query(value="Select * from faculty where email=?1",nativeQuery = true)
	public Faculty findByEmail(String email);
	
	@Query(value="Select * from faculty where fid=?1",nativeQuery = true)
	public List<Faculty> getFacultybyId(Long id);
	
	@Query(value="Select * from faculty where email=?1",nativeQuery = true)
	public List<Faculty> getFacultybyemail(String email);
	
	@Query(value="Select * from faculty where user_name=?1",nativeQuery = true)
	public List<Faculty> getFacultyByname(String faculty_name);
	
	@Query(value="Select * from faculty where user_name=?1",nativeQuery = true)
	public Faculty findname(String faculty_name);
	
	  

}
