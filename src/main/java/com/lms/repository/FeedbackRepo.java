package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

}
