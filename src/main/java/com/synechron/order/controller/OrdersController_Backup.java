package com.synechron.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.order.model.Order;
import com.synechron.order.service.OrderService;


@RestController
public class OrdersController_Backup {
	Logger logger = LoggerFactory.getLogger(OrdersController_Backup.class);
 
	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/orders",method = RequestMethod.GET)
	public List<Order> getAllOrder() {
		return orderService.findAll();
	}

	@PostMapping(value="/new")
	public Order createOrSaveOrder(@RequestBody Order newOrder) {
		logger.info("In OrderResource::createOrSaveOrder()::"+newOrder);
		return orderService.save(newOrder);
	}

	@RequestMapping(value="/get/{id}",method = RequestMethod.GET)
	Order getOrderById(@PathVariable Long orderId) {
		return orderService.get(orderId);
	}

	@RequestMapping(value="/edit/{id}",method = RequestMethod.PUT)
	Order updateOrder(@RequestBody Order order, @PathVariable Long orderId) {
		return orderService.get(orderId);
	}

	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	void deleteOrder(@PathVariable Long orderId) {
		orderService.delete(orderId);
	}

}
