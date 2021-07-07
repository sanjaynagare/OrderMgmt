package com.synechron.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class OrderNotFoundAdvice { 
  Logger logger = LoggerFactory.getLogger(OrderNotFoundAdvice.class);
  
  @ExceptionHandler(NoSuchElementException.class)
  public String orderNotFoundHandler(Model model) {
	  	logger.info("OrderNotFoundAdvice::orderNotFoundHandler():Order Not FOund");
	    model.addAttribute("errMsg","Requested Order Not found");
	    return  "error";
	  }
}
