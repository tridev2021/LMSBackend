package com.lms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long sid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="address")
	private String address;
	
	@Column(name="dateofbirth")
	private Date dateofbirth;
	
	@Column(name="mobileno")
	private double mobileno;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
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

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public double getMobileno() {
		return mobileno;
	}

	public void setMobileno(double mobileno) {
		this.mobileno = mobileno;
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

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", username=" + username + ", address=" + address + ", dateofbirth="
				+ dateofbirth + ", mobileno=" + mobileno + ", email=" + email + ", password=" + password + "]";
	}

	public Student(Long sid, String username, String address, Date dateofbirth, double mobileno, String email,
			String password) {
		super();
		this.sid = sid;
		this.username = username;
		this.address = address;
		this.dateofbirth = dateofbirth;
		this.mobileno = mobileno;
		this.email = email;
		this.password = password;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}