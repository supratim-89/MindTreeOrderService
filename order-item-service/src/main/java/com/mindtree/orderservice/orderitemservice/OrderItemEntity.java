package com.mindtree.orderservice.orderitemservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class OrderItemEntity {
private @Id @GeneratedValue Long id;
private String productcode;
private String productname;
private String quantity;


public String getProductcode() {
	return productcode;
}
public void setProductcode(String productcode) {
	this.productcode = productcode;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public OrderItemEntity() {
	super();
	// TODO Auto-generated constructor stub
}




}
