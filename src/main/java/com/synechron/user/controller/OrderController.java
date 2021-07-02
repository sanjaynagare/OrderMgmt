package com.synechron.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.order.model.Order;
import com.synechron.order.service.OrderService;

@RestController
@RequestMapping(value = "/orders", produces = { MediaType.APPLICATION_JSON_VALUE })
public class OrderController {
	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public List<Order> getAllOrder() {
		return orderService.findAll();
	}

	@PostMapping("/orders")
	Order createOrSaveOrder(@RequestBody Order newOrder) {
		logger.info("In OrderResource::createOrSaveOrder()::"+newOrder);
		return orderService.save(newOrder);
		
	}

	@GetMapping("/orders/{orderId}")
	Order getOrderById(@PathVariable("orderId") Long orderId) {
		return orderService.findById(orderId);
	}

	@PutMapping("/orders/{orderId}")
	Order updateOrder(@RequestBody Order order, @PathVariable("orderId") Long orderId) {
		return orderService.findById(orderId);
	}

	@DeleteMapping("/orders/{orderId}")
	void deleteOrder(@PathVariable("orderId") Long orderId) {
		orderService.delete(orderId);
	}

}
