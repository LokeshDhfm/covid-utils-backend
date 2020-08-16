package com.narendra.covid.utilities.covidutilities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.covid.utilities.covidutilities.entity.Product;
import com.narendra.covid.utilities.covidutilities.exception.ResourceDuplicationException;
import com.narendra.covid.utilities.covidutilities.exception.ServiceException;
import com.narendra.covid.utilities.covidutilities.repo.ProductRepository;
import com.narendra.covid.utilities.covidutilities.utils.enums.ProductType;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product newProduct(Product product) throws ServiceException {
		
		if(productRepository.existsByName(product.getName())) {
			throw new ResourceDuplicationException("Name already exists");
		}
		
		if(productRepository.findAll().contains(product)) {
			throw new RuntimeException("Product already exists");
		}
		if(product.getActualPrice()> product.getSellingPrice()) {
			throw new PriceException("actual price cannot be more than selling price");
		}
		return productRepository.save(product);
	}
	
	public ProductType[] getTypesOfProduct(){
		return ProductType.values();
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
