package com.shoppingcart.Order.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.Order.Model.Address;


public interface AddressRepository extends MongoRepository<Address, Integer>{
	
//	public List<Address> findByCustomerId(int customerId);

}
