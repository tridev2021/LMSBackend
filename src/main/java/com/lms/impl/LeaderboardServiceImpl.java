package com.lms.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Leaderboard;
import com.lms.repository.LeaderboardRepo;
import com.lms.service.LeadersboardService;

@Service
public class LeaderboardServiceImpl implements LeadersboardService {

	@Autowired
	LeaderboardRepo leadershiprepo;
	
	@Override
	public List<Leaderboard> getLeaderboard() {
		return  leadershiprepo.findAll();
	}

	@Override
	public void add(Leaderboard l) {
		leadershiprepo.save(l);
	}

}
