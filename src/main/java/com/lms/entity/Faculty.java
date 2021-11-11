package com.lms.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "faculty")
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FID;

	@Column(name = "username")
	private String username;

	

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name="mobile")
	private String mobile;
	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Course> course;
	

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

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

	@Override
	public String toString() {
		return "Faculty [FID=" + FID + ", username=" + username + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", mobile=" + mobile + "]";
	}

	public Faculty(Long fID, String username, String address, String email, String password, String mobile) {
		super();
		FID = fID;
		this.username = username;
		this.address = address;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	@OneToMany(targetEntity = Course.class ,cascade = CascadeType.ALL)
//	@JoinColumn(name="faculty_course",referencedColumnName = "FID")
//	private List<Course> courses;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "course_id")
//	private Course course;

//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

	
	
}
