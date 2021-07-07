package com.synechron.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.order.model.Order;
import com.synechron.order.service.OrderService;


@RestController
public class OrdersController {
	Logger logger = LoggerFactory.getLogger(OrdersController.class);
 
	@Autowired
	private OrderService orderService;

	@GetMapping(value="/orders",produces = "application/json")
	public List<Order> getAllOrder() {
		return orderService.findAll();
	}

	//@RequestMapping(value="/new",consumes = MediaType.TEXT_PLAIN_VALUE,method=RequestMethod.POST)
	@PostMapping("/new")
	public Order createOrSaveOrder(@RequestBody Order newOrder) {
		logger.info("In OrderResource::createOrSaveOrder()::");
		return orderService.save(newOrder);
	}

	@GetMapping(value="/get/{orderId}")
	Order getOrderById(@PathVariable("orderId") Long orderId) {
		logger.info("In OrderResource::getOrderById()::");
		return orderService.get(orderId);
	}

	@PutMapping(value="/edit/{orderId}")
	Order updateOrder(@RequestBody Order order, @PathVariable("orderId") Long orderId) {
		logger.info("In OrderResource::updateOrder()::");
		return orderService.get(orderId);
	}

	@DeleteMapping(value="/delete/{orderId}")
	void deleteOrder(@PathVariable("orderId") Long orderId) {
		logger.info("In OrderResource::deleteOrder()::");
		orderService.delete(orderId);
	}

}
