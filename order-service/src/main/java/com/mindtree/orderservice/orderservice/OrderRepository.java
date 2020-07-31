package com.mindtree.orderservice.orderservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{
	/*
	 * @Query("select u from OrderEntity u where u.productcode = ?1") OrderEntity
	 * findByProductcode(String productcode);
	 */
}
