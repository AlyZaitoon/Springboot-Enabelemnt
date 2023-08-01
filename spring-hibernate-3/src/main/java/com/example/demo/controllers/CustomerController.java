package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CustomerService;
import com.example.demo.dto.CustomerData;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<CustomerData> getAll(){
		return customerService.getAllCustomers();
	}
	@GetMapping("/customer/{id}")
	public CustomerData getCustomer(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	@PostMapping("/customer")
	public CustomerData saveCustomer(final @RequestBody CustomerData customerData) {
		return customerService.saveCustomer(customerData);
	}
	@DeleteMapping("/customer/{id}")
	public boolean deleteCustomer(@PathVariable Long id) {
		 customerService.deleteCustomer(id);
		 return true;
		 
	}
}
