package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long gid;
	
	@Column
	private String courseName;
	
	@Column
	private String batchName;
	
	@Column
	private String StudentName;
	
	@Column
	private String grade;

	public long getGid() {
		return gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Grade(long gid, String courseName, String batchName, String studentName, String grade) {
		super();
		this.gid = gid;
		this.courseName = courseName;
		this.batchName = batchName;
		StudentName = studentName;
		this.grade = grade;
	}

	public Grade() {
		}
	
}