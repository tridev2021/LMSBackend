package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Assessment")
public class Assessment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long AId;
	  @Column(name="techSkill")
	  private String techSkill;
	  @Column(name="totalAssessment")
	  private String totalAssessment;
	  @Column(name="facultyName")
	  private String facultyName;
	public Long getAId() {
		return AId;
	}
	public void setAId(Long aId) {
		AId = aId;
	}
	public String getTechSkill() {
		return techSkill;
	}
	public void setTechSkill(String techSkill) {
		this.techSkill = techSkill;
	}
	public String getTotalAssessment() {
		return totalAssessment;
	}
	public void setTotalAssessment(String totalAssessment) {
		this.totalAssessment = totalAssessment;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public Assessment(Long aId, String techSkill, String totalAssessment, String facultyName) {
		super();
		AId = aId;
		this.techSkill = techSkill;
		this.totalAssessment = totalAssessment;
		this.facultyName = facultyName;
	}
	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}
	  

}
