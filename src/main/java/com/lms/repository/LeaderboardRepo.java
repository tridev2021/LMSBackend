package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.Leaderboard;

@Repository
public interface LeaderboardRepo extends JpaRepository<Leaderboard, Long>{

}