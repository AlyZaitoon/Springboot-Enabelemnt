package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Employee;

import jakarta.transaction.Transactional;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao dao;
	
	@Transactional
	@Override
	public List<Employee> get() {
		return dao.get();
	}
	@Transactional
	@Override
	public Employee get(int id) {
		return dao.get(id);
	}
	@Transactional
	@Override
	public void save(Employee employee) {
		dao.save(employee);
		
	}
	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

}
