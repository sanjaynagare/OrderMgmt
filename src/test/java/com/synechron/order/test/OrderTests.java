package com.synechron.order.test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.synechron.order.dao.OrderRepository;
import com.synechron.order.model.Order;

@DataJpaTest
class OrderTests {

	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void testCreateOrder() {
		Order order=new Order("Order1","iphone 12",70000.00);
		Order savedOrder=orderRepository.save(order);
		assertNotNull(savedOrder);
	}
	@Test
	public void testUpdateOrder() {
		String orderName="OrderUpdate";
		Order order=new Order(orderName,"iphone 12",70000.00);
		order.setId(1L);
		orderRepository.save(order);
		Order updatedOrder=orderRepository.findById(1L).get();
		assertTrue(updatedOrder.getOrderName().equals(orderName));
	}
	@Test
	public void testfindAll() {
		Order order=new Order("Order1","iphone 12",70000.00);
		orderRepository.save(order);
		List<Order> orderList=orderRepository.findAll();
		assertFalse(orderList.size()==0);
	}
	@Test
	public void testDelete() {
		if(orderRepository.findById(1L).isPresent()) {
		Order deleteOrder = orderRepository.findById(1L).get();
		orderRepository.delete(deleteOrder);
		}
		assertFalse(orderRepository.findById(1L).isPresent());
	}
	
}
