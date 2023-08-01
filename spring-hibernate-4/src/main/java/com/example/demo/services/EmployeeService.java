package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {
	List<Employee> get();
	Employee get(int id);
	void save(Employee employee);
	void delete(int id);
}
