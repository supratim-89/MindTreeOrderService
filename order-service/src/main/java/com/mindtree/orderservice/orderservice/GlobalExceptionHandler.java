package com.mindtree.orderservice.orderservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(OrderNotFoundException.class)
    public void handleConflict() {
        System.out.println("Order not found");
    }
}
