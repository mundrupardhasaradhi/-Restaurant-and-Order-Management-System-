package com.vcube.restaurantservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.restaurantservice.model.FoodItem;
import com.vcube.restaurantservice.service.FoodItemService;

@RestController
@RequestMapping("/foods")
public class FoodItemController {
	
	@Autowired
	FoodItemService foodItemService;
	
	@GetMapping("/restaurant/{restaurantId}")
	public List<FoodItem> getMenuById(@PathVariable("id") long id){
		return foodItemService.getMenuByRestaurant(id);
	}
	
	@PostMapping
	public FoodItem addFoodItem(@RequestBody FoodItem foodItem) {
		return foodItemService.addFoodItem(foodItem);
	}
	
	@DeleteMapping("/{id}")
	public String deleteFoodItem(@PathVariable("id") long id) {
		foodItemService.deleteFoodItemById(id);
		return "FoodItem with Id: " + id + "deleted Successfully";
	}
	

}
