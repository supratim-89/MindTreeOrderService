package com.mindtree.orderservice.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "order-item-service",url="http://localhost:8080/")
public interface OrderServiceFeignClient {
	@RequestMapping(method = RequestMethod.POST, value = "/postOrderItems", consumes = "application/json")
	OrderItem saveOrderItem(@RequestBody  OrderItem storeId);
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOrderItemById/{id}", consumes = "application/json")
	OrderItem getOrderItemById(@PathVariable Long id);
}
