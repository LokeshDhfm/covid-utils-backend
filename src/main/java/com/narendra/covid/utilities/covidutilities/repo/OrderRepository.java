package com.narendra.covid.utilities.covidutilities.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.narendra.covid.utilities.covidutilities.entity.Customer;
import com.narendra.covid.utilities.covidutilities.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByCustomer(Customer customer);
	List<Order> findByPaid(Boolean paid);
	
}
