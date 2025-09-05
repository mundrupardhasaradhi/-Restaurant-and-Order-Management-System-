package com.vcube.restaurantservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.restaurantservice.model.Restaurant;
import com.vcube.restaurantservice.repo.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restaurantRepo;
	
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}
	
	public List<Restaurant> getAllRestaurants(){
		return restaurantRepo.findAll();
	}
	
	public Optional<Restaurant>  getRestaurantById(long id){
		return restaurantRepo.findById(id);
	}
	
	public Restaurant updateRestaurantById(Long id,Restaurant updated) {
		  return restaurantRepo.findById(id).map(existing -> {
	            existing.setName(updated.getName());
	            return restaurantRepo.save(existing);
		  }).orElseThrow(() -> new RuntimeException("Restaurant not found with id " + id));
	}
		 
	public void deleteRestaurant(long id) {
		restaurantRepo.deleteById(id);
	}

		  
		  


}
