package com.example.demo.services;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Demo1Application;
import com.example.demo.Entities.Student;

@RestController
@RequestMapping(value = "/rest/student")
public class StudentService {
	//get All students
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<Long, Student> getAllStudents() {
		return Demo1Application.hmStudent;

	}
	// get student by id 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student  getStudentById(@PathVariable long id) throws Exception {
		Student student;
		if(Demo1Application.hmStudent.containsKey(id)) {
			student = Demo1Application.hmStudent.get(id);
		}else {
			throw new Exception("Student " + id + " does not exist");
		}
		return student;
	}
	//Add Student
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Student addStudent(@RequestParam(value = "name") String name,
			@RequestParam(value = "subject", defaultValue = "unknown") String subject) {

		Student student = new Student(name, subject);
		Demo1Application.hmStudent.put(student.getId(), student);
		return student;

	}
	//Update Student
	@RequestMapping(value = "/update", method =RequestMethod.PUT )
	public Student updateStudent(@RequestBody Student student) throws Exception {
		if(Demo1Application.hmStudent.containsKey(student.getId())) {
			Demo1Application.hmStudent.put(student.getId(), student);
		}else {
			throw new Exception("Student " + student.getId()+ "does not exist");
		}
		return student;
	}
	//Delete Student
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public Student deleteStudent(@PathVariable long id)throws Exception {
		Student student;
		if(Demo1Application.hmStudent.containsKey(id))  {
			student = Demo1Application.hmStudent.get(id);
			Demo1Application.hmStudent.remove(id);
		}else {
			throw new Exception("Student " + id + " does not exist");
		}
		return student;
	}

}
