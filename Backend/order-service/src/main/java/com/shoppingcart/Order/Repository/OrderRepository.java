package com.shoppingcart.Order.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.Order.Model.Orders;

public interface OrderRepository extends MongoRepository<Orders,String>{
	
	public List<Orders> findByCustomerId(int customerId);
	
	public Orders findFirstByOrderByOrderIdDesc();
	
	public Orders findByOrderId(String id);


}
