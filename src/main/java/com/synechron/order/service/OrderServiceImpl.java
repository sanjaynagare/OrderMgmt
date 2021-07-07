package com.synechron.order.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.order.dao.OrderRepository;
import com.synechron.order.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	public Order save(Order order) {
		Order newOrder = order;
		return orderRepository.saveAndFlush(newOrder);
	}
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order get(Long id) {
		return orderRepository.findById(id).get();
	}

	public Order update(Order order, Long orderId) {
		Order updateOrder = orderRepository.findById(orderId).get();
		if (updateOrder == null) {
			logger.info("OrderService::Order Not Found");
		}
		else {
			updateOrder.setAmount(order.getAmount());
			updateOrder.setOrderName(order.getOrderName());
			updateOrder.setDescription(order.getDescription());
			orderRepository.saveAndFlush(updateOrder);
		}
		return updateOrder;

	}

	public Order delete(Long orderId) {
		Order deleteOrder = orderRepository.findById(orderId).get();
		if (deleteOrder == null) {
			logger.info("OrderService::Order Not Found");
		}
		else
		orderRepository.delete(deleteOrder);
		return deleteOrder;
	}

}
