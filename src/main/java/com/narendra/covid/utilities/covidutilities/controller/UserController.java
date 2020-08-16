package com.narendra.covid.utilities.covidutilities.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narendra.covid.utilities.covidutilities.entity.Customer;
import com.narendra.covid.utilities.covidutilities.service.CustomerService;

@Controller
@RequestMapping("user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping( consumes={"application/json"})
	public ResponseEntity<?> addUser(@RequestBody Customer customer){
		System.out.println(customer);
		return ok(customerService.newCustomer(customer));
	}
	
	@GetMapping
	public ResponseEntity<?> allUsers(){
		return ok(customerService.allCustomers());
	}
}
