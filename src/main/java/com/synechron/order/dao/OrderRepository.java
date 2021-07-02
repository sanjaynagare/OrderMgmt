package com.synechron.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synechron.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> 
{
	

	
}
