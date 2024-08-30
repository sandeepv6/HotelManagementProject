package com.otu.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.hotelmanagement.model.Customer;
import com.otu.hotelmanagement.service.CustomerService;


import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public String showCustomerPage(Model model) {
		List<Customer> allCustomers = customerService.getAllCustomers();
		model.addAttribute("customers", allCustomers);
		return "customers";
	}
	
	@PostMapping("/cust")
	public String saveCustomerInfo(@RequestParam String name, @RequestParam long phoneNumber, @RequestParam String email) {
		if(customerService.saveCustomerInfo(name, phoneNumber, email)) {
			return "redirect:/customers?sucess";
		}
		else {
			return "redirect:/customers?error";
		}
		
	}
	
	// Implement Delete customer Info
}