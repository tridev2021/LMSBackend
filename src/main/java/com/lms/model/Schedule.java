package com.lms.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
   private long id;
   
	@Column
   private String facultyName;
   
	@Column
   private String courseName;
   
	@Column
   private String batchName;
   
	@Column
   private String day;
   
	@Column
   private String duration;
	
	@Column
   private Date date;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFacultyName() {
	return facultyName;
}

public void setFacultyName(String facultyName) {
	this.facultyName = facultyName;
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

public String getDay() {
	return day;
}

public void setDay(String day) {
	this.day = day;
}

public String getDuration() {
	return duration;
}

public void setDuration(String duration) {
	this.duration = duration;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Schedule(long id, String facultyName, String courseName, String batchName, String day, String duration,
		Date date) {
	super();
	this.id = id;
	this.facultyName = facultyName;
	this.courseName = courseName;
	this.batchName = batchName;
	this.day = day;
	this.duration = duration;
	this.date = date;
}

public Schedule() {
	
}
     
}