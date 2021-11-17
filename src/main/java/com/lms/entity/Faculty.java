package com.lms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

// Entity class for Faculty

@Entity(name = "faculty")
@Table(name = "faculty")
public class Faculty {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FID;

	@Column(name = "userName")
	private String username;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="image" )
	private String image;
	
	@OneToMany (mappedBy = "faculty",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Course> course;
	

// Getter and Setters
	
	public Long getFID() {
		return FID;
	}

	public void setFID(Long fID) {
		FID = fID;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	// Constructor with arguments
	
	public Faculty(Long fID, String username, String address, String email, String password, String mobile) {
		super();
		FID = fID;
		this.username = username;
		this.address = address;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

// Default Constructor
	
	public Faculty() {
		super();
	}

	
}
