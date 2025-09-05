package com.vcube.restaurantservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.restaurantservice.model.FoodItem;
import com.vcube.restaurantservice.repo.FoodItemRepo;

@Service
public class FoodItemService {
	
	@Autowired
	FoodItemRepo foodItemRepo;
	
	public List<FoodItem> getMenuByRestaurant(Long restaurantId){
		return foodItemRepo.findByRestaurantId(restaurantId);
	}

	public FoodItem addFoodItem(FoodItem foodItem) {
		return foodItemRepo.save(foodItem);
	}
	
	public void deleteFoodItemById(Long id) {
		foodItemRepo.deleteById(id);
	}
}
