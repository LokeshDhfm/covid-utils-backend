package com.narendra.covid.utilities.covidutilities.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Size(min = 0)
	private Map<Product, Integer> products;
	
	private Double totalPrice;
	
	private Boolean paid;
	
	private Date date;
	
}
