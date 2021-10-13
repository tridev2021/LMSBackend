package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TechSkill")
public class TechSkill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tId;
	@Column(name="enrollStudent")
	private String enrollStudent;
	@Column(name="courseName")
	private String courseName;
	@Column(name="facultyName")
	private String facultyName;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getEnrollStudent() {
		return enrollStudent;
	}
	public void setEnrollStudent(String enrollStudent) {
		this.enrollStudent = enrollStudent;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public TechSkill(Long tId, String enrollStudent, String courseName, String facultyName) {
		super();
		this.tId = tId;
		this.enrollStudent = enrollStudent;
		this.courseName = courseName;
		this.facultyName = facultyName;
	}
	public TechSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TechSkill [tId=" + tId + ", enrollStudent=" + enrollStudent + ", courseName=" + courseName
				+ ", facultyName=" + facultyName + "]";
	}
	
	
	
	
    
}
