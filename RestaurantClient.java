package com.vcube.orderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vcube.orderservice.response.FoodItemResponse;
import com.vcube.orderservice.response.RestaurantResponse;

@FeignClient(name = "restaurant-service",url = "http://localhost:8181")
public interface RestaurantClient {
	
	@GetMapping("/restaurants/{id}")
	RestaurantResponse getRestaurantById(@PathVariable("id") long id);
	
	 @PutMapping("/{id}")
	 RestaurantResponse updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantResponse restaurant);

	 @GetMapping("/food/restaurant/{restaurantId}")
	 List<FoodItemResponse> getMenuByrestaurantId(@PathVariable("id") long id);

}
