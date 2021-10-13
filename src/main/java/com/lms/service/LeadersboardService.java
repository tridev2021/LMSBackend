package com.lms.service;

import java.util.List;

import com.lms.model.Leaderboard;


public interface LeadersboardService {

	public List<Leaderboard> getLeaderboard() ;
	   
	public void add(Leaderboard l) ;
}