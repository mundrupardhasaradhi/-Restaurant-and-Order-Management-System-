package com.vcube.orderservice.response;

import lombok.Data;

@Data
public class FoodItemResponse {

	private long id;
	private String name;
	private double price;
	private boolean availability;
}
