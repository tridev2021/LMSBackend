package com.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// Entity class for Course

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long CID;
	
	@Column(name="coursename")
	private String coursename;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="price")
	private String price;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonManagedReference
	private Faculty faculty;
	
	
// Getter and Setters
	
	public Long getCID() {
		return CID;
	}

	public void setCID(Long cID) {
		CID = cID;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
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
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	
	// Constructor with arguments
	
	public Course(Long cID, String coursename, String duration, String price) {
		super();
		CID = cID;
		this.coursename = coursename;
		this.duration = duration;
		this.price = price;
	}

// Default Constructor
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
//	@Transient
//	private String name;
	
//	@Transient
//	private String fid;
	
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="faculty_id")
//	private Faculty faculty;
	
//	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
//	@JoinColumn(name = "faculty_id")
//	private List<Faculty> faculties;
	

	

}

