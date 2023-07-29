package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {

	@Override
	public Collection<Student> getAllStudents() {
		
		return new ArrayList<Student>() {
			
			{
				add(new Student(1,"Mario","Nothing"));
			
			}
			
		};
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertStudent(Student s) {
		// TODO Auto-generated method stub

	}

}
