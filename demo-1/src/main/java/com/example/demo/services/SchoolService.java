package com.example.demo.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entities.Student;

@RestController
@RequestMapping(value = "/rest/school")
public class SchoolService {
	@RequestMapping(value="/students/{id}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable long id) {
		String URL="http://localhost:8080/rest/student/"+id;
		RestTemplate template= new RestTemplate();
		Student student= template.getForObject(URL, Student.class);
		return student;
	}
}
