package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lms.entity.TechSkill;

// Repository interface for techSkill

@Repository
public interface TechSkillRepo extends JpaRepository<TechSkill, Long> {

}
