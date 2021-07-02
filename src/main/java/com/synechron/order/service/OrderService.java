package com.synechron.order.service;

import java.util.List;

import com.synechron.order.model.Order;

public interface OrderService {
	public Order save(Order order);
	public List<Order> findAll();
	public Order findById(Long id);
	public Order update(Order order, Long id);
	public Order delete(Long id);
}
