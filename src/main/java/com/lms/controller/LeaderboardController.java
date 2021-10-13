package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.impl.LeaderboardServiceImpl;
import com.lms.model.Leaderboard;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/leaderboard")
public class LeaderboardController {
	
	@Autowired
	LeaderboardServiceImpl leaderboardServiceImpl;

	@GetMapping("/getall")
	 public List<Leaderboard> getLeaderboard(){
		return leaderboardServiceImpl.getLeaderboard();
		 
	 }
	
	@PostMapping("/insert")
	public void insert(@RequestBody Leaderboard l) {
		leaderboardServiceImpl.add(l);
	}
	
	
}
