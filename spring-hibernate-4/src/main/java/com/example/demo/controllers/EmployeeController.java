package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/all")
	public List<Employee> getAll(){
		return employeeService.get();
	}
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id){
		return employeeService.get(id);
	}
	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeById(@PathVariable int id){
		 employeeService.delete(id);
	}
	@PostMapping("/employee")
	public void create(@RequestBody Employee employee){
		employeeService.save(employee);
	}
	@PutMapping("/employee")
	public void update(@RequestBody Employee employee){
		employeeService.save(employee);
	}
}
