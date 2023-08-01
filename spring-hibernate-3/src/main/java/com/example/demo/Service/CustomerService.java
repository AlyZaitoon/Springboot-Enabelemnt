package com.example.demo.Service;

import java.util.List;

import com.example.demo.dto.CustomerData;



public interface CustomerService {
	
	public CustomerData saveCustomer(CustomerData customer);
	public boolean deleteCustomer(Long customerId);
	public List<CustomerData> getAllCustomers();
	public CustomerData getCustomerById(Long customerId);
}
