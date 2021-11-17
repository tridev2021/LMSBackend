package com.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;

	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public Admin(Long iD, String username, String email, String password) {
		super();
		ID = iD;
		this.username = username;
		this.email = email;
		this.password = password;

	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
	
	

}
