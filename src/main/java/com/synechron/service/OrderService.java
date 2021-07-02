package com.synechron.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.model.Order;
import com.synechron.repository.OrderRepository;

@Service
public class OrderService {
	Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	private OrderRepository orderReposiotry;

	public Order save(Order order) {
		Order newOrder = order;
		return orderReposiotry.saveAndFlush(newOrder);
	}
	
	public List<Order> findAll() {
		return orderReposiotry.findAll();
	}

	public Order findById(Long id) {
		return orderReposiotry.findById(id).get();
	}

	public Order update(Order order, Long id) {
		Order updateOrder = orderReposiotry.findById(id).get();
		if (updateOrder == null)
			logger.info("OrderService::Order Not Found");//throw new OrderException();
		else {
			updateOrder.setAmount(order.getAmount());
			updateOrder.setOrderName(order.getOrderName());
			updateOrder.setOrderDescription(order.getOrderDescription());
			orderReposiotry.saveAndFlush(updateOrder);
		}
		return updateOrder;

	}

	public Order delete(Long id) {
		Order deleteOrder = orderReposiotry.findById(id).get();
		if (deleteOrder == null)
			logger.info("OrderService::Order Not Found");//throw new OrderException();
		else
		orderReposiotry.delete(deleteOrder);
		return deleteOrder;
	}

}
