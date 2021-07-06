package com.synechron.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderNotFoundException extends RuntimeException {
	
	Logger logger = LoggerFactory.getLogger(OrderNotFoundException.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OrderNotFoundException(Long id) {
	    super("Could not find Order with Order Id: " + id);
	  }
}
