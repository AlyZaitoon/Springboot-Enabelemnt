package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerData;
import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;




@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public CustomerData saveCustomer(CustomerData customer) {
		Customer c = populateCustomerEntity(customer);
		return populateCustomerData(customerRepository.save(c));
	}

	@Override
	public boolean deleteCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
		return true;
	}

	@Override
	public List<CustomerData> getAllCustomers() {
		
		List<Customer> cust = customerRepository.findAll();
		List <CustomerData> custData = new ArrayList<>();
		cust.forEach(customer->{
			custData.add(populateCustomerData(customer));
		});
		return custData;
	}

	@Override
    public CustomerData getCustomerById(Long customerId) {
        return populateCustomerData(customerRepository.findById(customerId).orElse(new Customer()));
    }

    private CustomerData populateCustomerData(final Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        return customerData;
    }

    /**
     * Method to map the front end customer object to the JPA customer entity.
     * @param customerData
     * @return Customer
     */
    private Customer populateCustomerEntity(CustomerData customerData) {
        Customer customer = new Customer();
        customer.setFirstName(customerData.getFirstName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        customer.setId(customerData.getId());
        return customer;
    }

}
