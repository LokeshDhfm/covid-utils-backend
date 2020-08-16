package com.narendra.covid.utilities.covidutilities.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.narendra.covid.utilities.covidutilities.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	
	List<Customer> findByName(String name);
	
}
