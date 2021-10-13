package com.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Schedule;
import com.lms.impl.ScheduleServiceImpl;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleServiceImpl serviceImpl;
	
	@GetMapping("/allschedule")
	public List<Schedule> gatAllSchedule(){
		return serviceImpl.getSchedule();
	}
	
	@GetMapping("/schedule/{ID}")
	public Optional<Schedule> getDataByID(@PathVariable Long ID){
		return (Optional<Schedule>) serviceImpl.findById(ID);
       }
       
	 @PostMapping("/insert")
	public void insert(@RequestBody Schedule sc) {
		serviceImpl.add(sc);
	}
		
	@PutMapping("/update/{id}")
	public void update(@RequestBody Schedule s, @PathVariable Long id) {
		serviceImpl.updateSchedule(s, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@RequestBody Schedule s , @PathVariable long id ) {
		serviceImpl.deleteSchedule(id);
	}
	
}