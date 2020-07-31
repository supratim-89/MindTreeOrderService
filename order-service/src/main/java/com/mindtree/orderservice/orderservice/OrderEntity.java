package com.mindtree.orderservice.orderservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class OrderEntity {
private @Id @GeneratedValue Long id;
@NotNull
private String customername;
private String orderdate;
@NotNull
private String shippingaddress;
private Long orderitemid;
private int total;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getOrderdate() {
	return orderdate;
}
public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
}
public String getShippingaddress() {
	return shippingaddress;
}
public void setShippingaddress(String shippingaddress) {
	this.shippingaddress = shippingaddress;
}

public Long getOrderitemid() {
	return orderitemid;
}
public void setOrderitemid(Long orderitemid) {
	this.orderitemid = orderitemid;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}


}
