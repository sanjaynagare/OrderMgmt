package com.synechron.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.synechron.config.WebSecurityConfig;

@ControllerAdvice
public class OrderNotFoundAdvice { 
  Logger logger = LoggerFactory.getLogger(OrderNotFoundAdvice.class);
  @ResponseBody
  @ExceptionHandler(OrderNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String orderNotFoundHandler(OrderNotFoundException ex) {
    return ex.getMessage();
  }
}
