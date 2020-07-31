package com.mindtree.orderservice.orderitemservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Long>{
	@Query("select u from OrderItemEntity u where u.productcode = ?1")
	OrderItemEntity findByProductcode(String productcode);
}
