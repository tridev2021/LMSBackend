package com.lms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="study_batch")
public class StudyBatch {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long bid;
	
	@Column
	private String batchName;
	
	@Column
	private String courseName;
	
	@Column
	private String duration;
	
	@Column
	private long enrollStudent;
	
	@Column
	private Date startDate;
	
	@Column
	private Date endDate;
	
	@Column
	private String facultyName;

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
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

	public long getEnrollStudent() {
		return enrollStudent;
	}

	public void setEnrollStudent(long enrollStudent) {
		this.enrollStudent = enrollStudent;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public StudyBatch(long bid, String batchName, String courseName, String duration, long enrollStudent,
			Date startDate, Date endDate, String facultyName) {
		super();
		this.bid = bid;
		this.batchName = batchName;
		this.courseName = courseName;
		this.duration = duration;
		this.enrollStudent = enrollStudent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.facultyName = facultyName;
	}

	public StudyBatch() {
	}
	
}