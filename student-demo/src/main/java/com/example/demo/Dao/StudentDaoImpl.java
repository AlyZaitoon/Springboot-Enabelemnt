package com.example.demo.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	private static Map<Integer, Student> students;
	static {
		students = new HashMap<Integer, Student>() {
			{

				put(1, new Student(1, "Said", "Computer Science"));
				put(2, new Student(2, "Mariam", "Computer Engineering"));
				put(3, new Student(3, "Ahmed", "Biology"));
			}

		};
	}

	@Override
	public Collection<Student> getAllStudents() {
		return students.values();
	}

	@Override
	public Student getStudentById(int id) {
		return students.get(id);
	}

	@Override
	public void deleteStudent(int id) {
		students.remove(id);
	}
	@Override
	public void updateStudent(Student s) {
		Student student = students.get(s.getId());
		student.setName(s.getName());
		student.setCourse(s.getCourse());
		students.put(student.getId(), student);
	}
	@Override
	public void insertStudent(Student s) {
		students.put(s.getId(), s);
	}
	
}
