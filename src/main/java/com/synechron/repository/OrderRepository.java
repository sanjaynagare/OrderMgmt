package com.synechron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synechron.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> 
{
	

	
}
