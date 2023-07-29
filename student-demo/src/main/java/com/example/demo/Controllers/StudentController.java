package com.example.demo.Controllers;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Student s) {
		studentService.updateStudent(s);
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void insertStudent(@RequestBody Student s) {
		studentService.insertStudent(s);
	}
	
}
