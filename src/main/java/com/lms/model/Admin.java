package com.lms.model;

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
	@Column(name = "verificationcode", length = 64 ,updatable = false)
    private String verificationcode;
	@Column(name="enabled" )
	private boolean enabled;
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
	public String getVerificationcode() {
		return verificationcode;
	}
	public void setVerificationcode(String verificationcode) {
		this.verificationcode = verificationcode;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", verificationcode=" + verificationcode + ", enabled=" + enabled + "]";
	}
	public Admin(Long iD, String username, String email, String password, String verificationcode, boolean enabled) {
		super();
		ID = iD;
		this.username = username;
		this.email = email;
		this.password = password;
		this.verificationcode = verificationcode;
		this.enabled = enabled;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
	
	

}
