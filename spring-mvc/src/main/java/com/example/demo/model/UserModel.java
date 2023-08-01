package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class UserModel {
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	@Id
	@GeneratedValue
	private Long Id;
	
	private String fname;

	private String lname;

	private String email;

	private String mobile;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
