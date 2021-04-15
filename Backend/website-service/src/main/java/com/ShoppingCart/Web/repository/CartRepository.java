package com.ShoppingCart.Web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ShoppingCart.Web.model.Cart;



public interface CartRepository extends MongoRepository<Cart, Integer> {
	
	public Cart findByCartId(int cartId);

}
