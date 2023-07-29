package com.example.demo.Entities;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
	private long id;
	private String name;
	private String subject;

	public Student() {
	}

	public Student(String Name, String Subject) {
		this.id = (new Date()).getTime();
		this.name = Name;
		this.subject = Subject;

	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", subject='" + subject + '\'' + '}';
	}

}
