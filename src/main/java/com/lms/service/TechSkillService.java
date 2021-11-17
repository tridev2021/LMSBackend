package com.lms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lms.entity.TechSkill;

//Service interface for TechSkill

public interface TechSkillService {
	
     public List<TechSkill> getdata();

     public TechSkill insertdata(TechSkill techskill);

     public ResponseEntity<TechSkill> update(TechSkill techskill, Long tId);
	
}
