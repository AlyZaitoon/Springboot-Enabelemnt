package com.example.demo.Dao;

import java.util.Collection;

import com.example.demo.Entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	void deleteStudent(int id);

	void updateStudent(Student s);

	void insertStudent(Student s);

}