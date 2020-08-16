package com.narendra.covid.utilities.covidutilities.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.narendra.covid.utilities.covidutilities.dto.OrderDTO;
import com.narendra.covid.utilities.covidutilities.exception.CovidUtilsException;
import com.narendra.covid.utilities.covidutilities.service.OrderService;

@Controller
@RequestMapping("order")
@CrossOrigin

public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping( consumes={"application/json"})
	public ResponseEntity<?> orderService(@RequestBody OrderDTO order) throws CovidUtilsException {
		System.out.println(order);
		return ok(orderService.newOrder(order));
	}
	
	@GetMapping
	public ResponseEntity<?> allOrders(){
		return ok(orderService.getAllOrders());
	}
	
	@GetMapping("payment/{paid}")
	public ResponseEntity<?> getOrdersByPaymentStatus(@PathVariable Boolean paid){
		return ok(orderService.getAllPaidOrders(paid));
	}
	
	@GetMapping("details/{id}")
	public ResponseEntity<?> getOrderDetailsProducts(@PathVariable Long id){
		return ok(orderService.getDetails(id));
	}
	
	@GetMapping("profit")
	public ResponseEntity<?> getProfit(){
		return ok(orderService.getProfit());
	}
}
