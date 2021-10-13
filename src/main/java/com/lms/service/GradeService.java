package com.lms.service;

import java.util.List;
import java.util.Optional;

import com.lms.model.Grade;

public interface GradeService {

    public List<Grade> getGrade();
    
    public Optional<Grade> findById(Long id);
    
     public Grade insert(Grade g);
	
	public void updateGrade(Grade g, long gid);
	
	public void deleteGrade( long gid);
	
}