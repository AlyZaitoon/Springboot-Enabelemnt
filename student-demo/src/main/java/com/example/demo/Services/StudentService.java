package com.example.demo.Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dao.StudentDao;
import com.example.demo.Entity.Student;

@Service
public class StudentService {
	@Autowired
	@Qualifier("mongoData")
	private StudentDao dao;

	public Collection<Student> getAllStudents() {
		return dao.getAllStudents();
	}

	public Student getStudentById(int id) {
		return dao.getStudentById(id);
	}

	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}
	public void updateStudent(Student s) {
		dao.updateStudent(s);
	}
	public void insertStudent(Student s) {
		dao.insertStudent(s);
	}
	
	
}
