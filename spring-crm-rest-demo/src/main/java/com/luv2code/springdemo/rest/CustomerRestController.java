package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// Inject the customer service
	
	@Autowired
	private CustomerService customerService;
	
	
	// add mapping to get customer list
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	// add mapping to get single customer data
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer c = customerService.getCustomer(customerId);
		
		if(c==null) {
			throw new CustomerException("Customer ID not found: " + customerId);
		}
		
		return c;
	}
	
	
}













