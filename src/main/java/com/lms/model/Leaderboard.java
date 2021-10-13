package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Leaderboard")
public class Leaderboard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long LId;
	@Column(name="StudentName")
	private String studentName;
	@Column(name="CourseName")
	private String courseName;
	@Column(name="Score")
	private String score;
	public Long getLId() {
		return LId;
	}
	public void setLId(Long lId) {
		LId = lId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Leaderboard(Long lId, String studentName, String courseName, String score) {
		super();
		LId = lId;
		this.studentName = studentName;
		this.courseName = courseName;
		this.score = score;
	}
	public Leaderboard() {
		super();
		}
}