package com.synechron.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.synechron.order.model.Order;
import com.synechron.order.service.OrderService;

@Controller
public class OrderController {
	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Order> listOrders = orderService.findAll();
		model.addAttribute("listOrders", listOrders);
		
		return "home";
	}
	
	@RequestMapping("/new")
	public String showNewOrderForm(Model model) {
		Order order = new Order();
		model.addAttribute("order1", order);
		
		return "new_order";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order) {
		orderService.save(order);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditOrderForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_order");
		
		Order order = orderService.get(id);
		mav.addObject("order1", order);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteOrder(@PathVariable(name = "id") Long id) {
		orderService.delete(id);
		
		return "redirect:/";
	}

}
