package com.shoppingcart.Cart.Service;

import java.util.List;

import com.shoppingcart.Cart.Model.Cart;

public interface CartService {

//	ResponseEntity<Products> getAllProducts();

	List<Cart> getAllCarts();

	Cart getCartById(int id);

	void updateCart(int cid,int id);

	void addToCart(int cId, int pId);

	void addCart(int id);

	void deleteCart(int cId);

}
