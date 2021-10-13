package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback_course")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	Long feedback_id;
	
	@Column(name="courseName")
	private String courseName;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="price")
	private String price;
	
	@Column(name="comments")
	private String comments;
	
	public Long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(Long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
   
}