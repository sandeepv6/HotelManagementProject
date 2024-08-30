package com.otu.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.hotelmanagement.model.Customer;
import com.otu.hotelmanagement.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public boolean saveCustomerInfo(String name, long phoneNumber, String email) {
		Customer customer = new Customer(name, phoneNumber, email);
		customerRepository.save(customer);
		return true;
	}
	
	public void deleteCustomerInfo(Long customerID) {
		customerRepository.deleteById(customerID);
	}
}
