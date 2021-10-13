package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.QuestionUpload;

@Repository
public interface QuestionUploadRepo extends JpaRepository<QuestionUpload, Long> {

}
