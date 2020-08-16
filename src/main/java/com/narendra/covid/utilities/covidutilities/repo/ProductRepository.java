package com.narendra.covid.utilities.covidutilities.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.narendra.covid.utilities.covidutilities.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	boolean existsByName(String name);
	
}
