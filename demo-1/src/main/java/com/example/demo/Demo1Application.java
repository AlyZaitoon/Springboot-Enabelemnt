package com.example.demo;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entities.Student;



@SpringBootApplication
public class Demo1Application {

	public static HashMap<Long,Student> hmStudent;
	public static void main(String[] args) {
		hmStudent = new HashMap<Long,Student>();
		Student two =  new Student("Steven","biology");
		hmStudent.put(two.getId(), two);
		
		SpringApplication.run(Demo1Application.class, args);

		Student one =  new Student("John","math");
		hmStudent.put(one.getId(), one);
	}

}
