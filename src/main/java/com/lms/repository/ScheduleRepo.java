package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.Schedule;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

}
