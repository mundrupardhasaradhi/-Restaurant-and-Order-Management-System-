package com.vcube.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.restaurantservice.model.Restaurant;
import com.vcube.restaurantservice.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@PostMapping("/addRestaurant")
	public Restaurant addRestaurants(@RequestBody Restaurant restaurant) {
		return restaurantService.createRestaurant(restaurant);
	}
	
	@GetMapping
	public List<Restaurant> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}
	
	@GetMapping("/{id}")
	public Restaurant getRestaurantById(@PathVariable ("id") long id){
		return restaurantService.getRestaurantById(id).orElseThrow(() -> new RuntimeException("Restaurant Not found by id : " + id));
	}
	
	@PutMapping("/update/{id}")
	public Restaurant updateRestaurant(@PathVariable("id") long id,@RequestBody Restaurant restaurant) {
		return restaurantService.updateRestaurantById(id, restaurant);
	}
	
	@DeleteMapping("/{id}")
	public String deleteRestaurant(@PathVariable("id") long id) {
		 restaurantService.deleteRestaurant(id);
		 return "Restaurant with id: " + id + "deleted successfully";
	}

}
