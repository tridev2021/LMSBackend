package com.lms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "faculty")
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FID;

	@Column(name = "facultyName")
	private String facultyName;

	
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="address")
	private String address;
	
	@OneToMany()
	@JoinTable(name="faculty_course",joinColumns = @JoinColumn(name="FID"), inverseJoinColumns = @JoinColumn(name="CID"))
	private List<Course> courses;

	public Long getFID() {
		return FID;
	}

	public void setFID(Long fID) {
		FID = fID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
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

	
	public Faculty(Long fID, String facultyName,  String email, String password,String address,
			String mobile) {
		super();
		FID = fID;
		this.facultyName = facultyName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}

	public Faculty() {
		super();
	}

	
}
