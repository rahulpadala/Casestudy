package com.shoppingcart.Cart.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.Cart.Model.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer> {
	
	public Cart findByCartId(int cartId);

}
