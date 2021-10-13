package com.lms.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Schedule;
import com.lms.repository.ScheduleRepo;
import com.lms.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepo repo;

	@Override
	public List<Schedule> getSchedule() {
		return repo.findAll();
	}

	@Override
	public Optional<Schedule> findById(Long id) {
		return (Optional<Schedule>) repo.findById(id);
		}
	
	@Override
	public void add(Schedule s) {
		repo.save(s);
	}

	@Override
	public void updateSchedule(Schedule s, long id) {
		Schedule sch = repo.findById(id).orElseThrow(null);
		sch.setBatchName(s.getBatchName());
		
		repo.save(s);
	}

	@Override
	public void deleteSchedule( long id) {
		repo.deleteById(id);
	}

}