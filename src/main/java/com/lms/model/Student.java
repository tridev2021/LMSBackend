package com.lms.model;

import java.util.Date;

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
	
	@Column(name="studentName")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="mobileNo")
	private String mobileNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public Long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	public Student(Long sid, String name, String address, Date date, String mobileNo, String email,
			String password) {
		super();
		this.sid = sid;
		this.name = name;
		this.address = address;
		this.dateOfBirth = date;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		
	}

	public Student() {
		
	}
	
}