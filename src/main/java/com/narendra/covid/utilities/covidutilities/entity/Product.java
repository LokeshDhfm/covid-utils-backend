package com.narendra.covid.utilities.covidutilities.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.narendra.covid.utilities.covidutilities.utils.enums.ProductType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Integer actualPrice;

	private Integer sellingPrice;

	@Enumerated
	private ProductType type;

	private Integer quantity;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		 builder.append("{\"id\":").append(id)
				.append(",\n \"name\":").append("\"").append(name).append("\"")
				.append(",\n \"actualPrice\":").append(actualPrice)
				.append(",\n \"sellingPrice\":").append(sellingPrice)
				.append(",\n \"type\":").append("\"").append(type).append("\"")
				.append(",\n \"quantity\":").append(quantity)
				.append("\n}");
		return builder.toString();
	}

}
