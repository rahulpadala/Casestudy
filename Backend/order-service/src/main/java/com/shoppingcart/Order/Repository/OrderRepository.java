package com.shoppingcart.Order.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.Order.Model.Orders;

public interface OrderRepository extends MongoRepository<Orders,Integer>{
	
	public List<Orders> findByCustomerId(int customerId);
	
	public Orders findFirstByOrderByOrderIdDesc();

}
