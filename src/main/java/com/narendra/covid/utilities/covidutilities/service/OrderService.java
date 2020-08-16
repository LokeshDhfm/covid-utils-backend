package com.narendra.covid.utilities.covidutilities.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.covid.utilities.covidutilities.dto.OrderDTO;
import com.narendra.covid.utilities.covidutilities.entity.Customer;
import com.narendra.covid.utilities.covidutilities.entity.Order;
import com.narendra.covid.utilities.covidutilities.entity.Product;
import com.narendra.covid.utilities.covidutilities.exception.ResourceNotFound;
import com.narendra.covid.utilities.covidutilities.exception.ServiceException;
import com.narendra.covid.utilities.covidutilities.repo.CustomerRepository;
import com.narendra.covid.utilities.covidutilities.repo.OrderRepository;
import com.narendra.covid.utilities.covidutilities.repo.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public Order newOrder(OrderDTO orderDTO) throws ServiceException {

		Customer customer = customerRepository.findById(orderDTO.getCustomerId())
				.orElseThrow(() -> new ResourceNotFound("No customer with id " + orderDTO.getCustomerId()));

		Map<Product, Integer> products = new HashMap<Product, Integer>();

		orderDTO.getProducts().forEach((prodId, quantity) -> {

			try {
				Product product = productRepository.findById(prodId)
						.orElseThrow(() -> new ResourceNotFound("no product found with id " + prodId));
				if ( product.getQuantity() <= 0) {
					throw new RuntimeException(product.getName()+ " is out of stock");
				}
				else if(product.getQuantity() < quantity) {
					throw new RuntimeException(product.getName()+ " only "+product.getQuantity()+ " available");
				}
				product.setQuantity(product.getQuantity() - quantity);
				saveToMap(products, product, quantity);
			} catch (ResourceNotFound e) {
				throw new RuntimeException(e.getMessage());
			}

		});
		Order order = Order
				.builder().customer(customer).paid(orderDTO.getPaid()).products(products).totalPrice(products.entrySet()
						.stream().mapToDouble(entry -> entry.getKey().getSellingPrice() * entry.getValue()).sum())
						.date(new Date(System.currentTimeMillis()))
				.build();

		return orderRepository.save(order);
	}

	private void saveToMap(Map<Product, Integer> products, Product product, Integer quantity) {
		products.put(product, quantity);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public List<Order> getAllOrdersByCustomer(Long customerId) throws ServiceException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFound("No customer with id " + customerId));
		return orderRepository.findByCustomer(customer);
	}

	public List<Order> getAllPaidOrders(Boolean unpaid) {
		return orderRepository.findByPaid(unpaid);
	}

	public Map<Product, Integer> getDetails(Long id) {
		return orderRepository.findById(id).get().getProducts();
	}

	static Double profit =  0.0;
	public Double getProfit() {
		return orderRepository.findAll().stream().filter(order -> order.getPaid()).mapToDouble(order->{
			profit = 0.0;
			order.getProducts().forEach((product,quantity)->{
				profit += (product.getSellingPrice()- product.getActualPrice()) * quantity;
			});
			return profit;
		}).sum();
	}
}
