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

import com.narendra.covid.utilities.covidutilities.entity.Product;
import com.narendra.covid.utilities.covidutilities.exception.CovidUtilsException;
import com.narendra.covid.utilities.covidutilities.service.ProductService;

@Controller
@RequestMapping("product")
@CrossOrigin

public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> addNewProduct(@RequestBody Product product) throws CovidUtilsException {
		System.out.println(product);
		return  ok(productService.newProduct(product));
	}
	
	@GetMapping
	public ResponseEntity<?> allProducts(){
		return ok(productService.getAllProducts());
	}
	
	@GetMapping("types")
	public ResponseEntity<?> getTypes(){
		return ok(productService.getTypesOfProduct());
	}
}
