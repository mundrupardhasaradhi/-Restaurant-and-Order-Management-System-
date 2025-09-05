package com.vcube.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.orderservice.client.RestaurantClient;
import com.vcube.orderservice.model.Order;
import com.vcube.orderservice.repo.OrderRepo;
import com.vcube.orderservice.response.RestaurantResponse;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	RestaurantClient restaurantClient;
	
	public Order placeOrder(Order order) {
		//validate restaurant using feign
		RestaurantResponse restaurant = restaurantClient.getRestaurantById(order.getRestaurantId());
		if(restaurant == null) {
			throw new RuntimeException("Restaurant not found" + order.getRestaurantId());
		}
		
		order.setStatus("PENDING");
		return orderRepo.save(order);
	}
	
	public Order getOrderById(Long id) {
		return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("order not found with id" + id));
	}
	
	
	public List<Order> getOrdersByCustomer(Long customerId){
		return orderRepo.getOrdersByCustomer(customerId);
	}

	
	public Order updateStatus(Long id,String status) {
		return orderRepo.findById(id).map(order -> {
			order.setStatus(status);
			return orderRepo.save(order);
		}).orElseThrow(() -> new RuntimeException("order Not found with id" + id));
	}
	
	
	
	
	
}
