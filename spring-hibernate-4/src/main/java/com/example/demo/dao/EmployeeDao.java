package com.example.demo.dao;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeDao {
	List<Employee> get();
	Employee get(int id);
	void save(Employee employee);
	void delete(int id);
}
