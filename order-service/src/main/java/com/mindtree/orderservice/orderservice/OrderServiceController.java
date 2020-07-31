package com.mindtree.orderservice.orderservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderServiceController {
	@Autowired
	private  OrderRepository repository;
	
	@Autowired
	OrderServiceFeignClient feignClient;
	
	@GetMapping("/getAllOrders")
	public List<OrderEntity> getAllOrderItems()
	{   List<OrderEntity> fullOrderList=new ArrayList<OrderEntity>();
	    fullOrderList=repository.findAll();
		return fullOrderList;
	}
	
	
	@RequestMapping(value="/postOrders",method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody ResponseEntity<String> postOrderItem(@Valid @RequestBody  Order order) {
		 OrderEntity orderEntity=new OrderEntity();
		 orderEntity.setCustomername(order.getCustomername());
		 orderEntity.setOrderdate(order.getOrderdate());
		 orderEntity.setShippingaddress(order.getShippingaddress());
		 orderEntity.setTotal(order.getTotal());
		 OrderItem item=feignClient.saveOrderItem(order.getOrderitem());
		 System.out.println("The orderitemsaved is "+item.getId());
		 orderEntity.setOrderitemid(item.getId());
		 repository.save(orderEntity);
	   return new ResponseEntity<String>("Success in posting the Order", HttpStatus.OK);
	}
	
	
	  @GetMapping("/getOrder/{id}") public Order
	  getOrderByProductId(@PathVariable String id) {
	  Long convertedid=Long.parseLong(id);
	  Optional<OrderEntity> oe=repository.findById(convertedid); 
	  if(oe.isPresent())
	  {
		  Order o=new Order();
		  OrderEntity orderEntity=oe.get();
		  o.setCustomername(orderEntity.getCustomername());
		  o.setOrderdate(orderEntity.getOrderdate());
		  o.setShippingaddress(orderEntity.getShippingaddress());
		  o.setTotal(orderEntity.getTotal());
		  System.out.println("the orderid is "+orderEntity.getOrderitemid());
		  OrderItem item=feignClient.getOrderItemById(orderEntity.getOrderitemid());
		  o.setOrderitem(item);
		  return o;
	  }
	  else {
		  throw new OrderNotFoundException();
	  }
	  
	  
	  
	  
	  }
	
    
}
