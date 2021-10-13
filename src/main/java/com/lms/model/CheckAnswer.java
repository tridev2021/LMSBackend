package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkAnswer")
public class CheckAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long CId;
	@Column(name="Question")
	private String question;
	@Column(name="Answer")
	private String answer;
	public Long getCId() {
		return CId;
	}
	public void setCId(Long cId) {
		CId = cId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
