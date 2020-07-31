package com.mindtree.orderservice.orderitemservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class OrderItemController {
	
	@Autowired
	private  OrderItemRepository repository;
	
	@GetMapping("/getAllOrderItems")
	public List<OrderItemEntity> getAllOrderItems()
	{   List<OrderItemEntity> fullOrderItemList=new ArrayList<OrderItemEntity>();
	    fullOrderItemList=repository.findAll();
		return fullOrderItemList;
	}
	
	
	@RequestMapping(value="/postOrderItems",method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody OrderItemEntity postOrderItem(@RequestBody  OrderItem orderItem) {
		 System.out.println(orderItem.getProductname());
		 OrderItemEntity orderItemEntity=new OrderItemEntity();
		 orderItemEntity.setProductcode(orderItem.getProductcode());
		 orderItemEntity.setProductname(orderItem.getProductname());
		 orderItemEntity.setQuantity(orderItem.getQuantity());
		 OrderItemEntity orderItemEntitySaved=repository.save(orderItemEntity);
	   return orderItemEntitySaved;
	}
	
	@GetMapping("/getOrderItem/{productcode}")
	public OrderItemEntity getOrderItemByProductCode(@PathVariable String productcode)
	{
	    OrderItemEntity oe=(OrderItemEntity)repository.findByProductcode(productcode);
		return oe;
	}
	
	 @GetMapping("/getOrderItemById/{id}") public OrderItemEntity
	 getOrderItemById(@PathVariable String id) {
		 Long convertedid=Long.parseLong(id);
		  Optional<OrderItemEntity> oie=repository.findById(convertedid); 
		  if(oie.isPresent())
		  {
			  OrderItemEntity orderEntity=oie.get();
			  return orderEntity;
		  }
		  else
		  {
		 return null;
		  }
		 
	 }
	 
    
	
}
