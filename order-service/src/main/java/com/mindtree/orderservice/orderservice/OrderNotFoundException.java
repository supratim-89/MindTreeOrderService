package com.mindtree.orderservice.orderservice;

public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(){
		super("OrderNotFoundException");
	}
}
