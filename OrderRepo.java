package com.vcube.orderservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.orderservice.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long>{
	
	
	List<Order> getOrdersByCustomer(long customerId);
}
