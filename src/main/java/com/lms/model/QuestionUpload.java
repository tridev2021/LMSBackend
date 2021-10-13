package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QuestionUpload")
public class QuestionUpload {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long QId;
	  @Column(name="Questions")
	  private String questions;
	  @Column(name="option1")
	  private String option1;
	  @Column(name="option2")
	  private String option2;
	  @Column(name="option3")
	  private String option3;
	public Long getQId() {
		return QId;
	}
	public void setQId(Long qId) {
		QId = qId;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public QuestionUpload(Long qId, String questions, String option1, String option2, String option3) {
		super();
		QId = qId;
		this.questions = questions;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
	}
	public QuestionUpload() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}