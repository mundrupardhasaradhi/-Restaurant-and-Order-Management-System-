package com.vcube.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.orderservice.model.Order;
import com.vcube.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping
	public Order placeOrder(@RequestBody Order order) {
		return service.placeOrder(order);
	}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id) {
		return service.getOrderById(id);
	}

	@GetMapping("/customer/{customerId}")
	public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
		return service.getOrdersByCustomer(customerId);
	}

	@PutMapping("/{id}/status")
	public Order updateOrderStatus(@PathVariable ("id") Long id,@RequestBody String status) {
		return service.updateStatus(id, status);
	}
}
