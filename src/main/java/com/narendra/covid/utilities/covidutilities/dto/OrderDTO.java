package com.narendra.covid.utilities.covidutilities.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private Long customerId;
	
	private Map<Long, Integer> products;
	
	private Boolean paid;
}
