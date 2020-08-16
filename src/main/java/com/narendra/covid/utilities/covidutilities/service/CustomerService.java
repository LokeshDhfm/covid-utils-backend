package com.narendra.covid.utilities.covidutilities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.covid.utilities.covidutilities.entity.Customer;
import com.narendra.covid.utilities.covidutilities.repo.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer newCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> allCustomers() {
		return customerRepository.findAll();
	}
	
}
