package com.lms.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Grade;
import com.lms.repository.GradeRepo;
import com.lms.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepo repo;
	
	@Override
	public List<Grade> getGrade() {
		return repo.findAll();
	}

	@Override
	public Optional<Grade> findById(Long id) {
		return (Optional<Grade>) repo.findById(id);
		}
	
	@Override
	public Grade insert(Grade g) {
	  return repo.save(g);
	}

	@Override
	public void updateGrade(Grade g, long gid) {
		Grade grade = repo.findById(gid).orElseThrow(null);
		grade.setBatchName(g.getBatchName());
		grade.setCourseName(g.getCourseName());
		grade.setStudentName(g.getStudentName());
		grade.setGrade(g.getGrade());
		
		repo.save(g);
	}

	@Override
	public void deleteGrade( long gid) {
		repo.deleteById(gid);
	}


}