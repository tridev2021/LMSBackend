package com.lms.service;

import java.util.List;
import java.util.Optional;

import com.lms.model.Schedule;

public interface ScheduleService {

	    public List<Schedule> getSchedule();
	   
	    public Optional<Schedule> findById(Long id);
		
		public void add(Schedule s);
		
		public void updateSchedule(Schedule s, long id);
		
		public void deleteSchedule(long id);
	
}