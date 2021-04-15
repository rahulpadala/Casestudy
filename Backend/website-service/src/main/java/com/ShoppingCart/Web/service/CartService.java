package com.ShoppingCart.Web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ShoppingCart.Web.model.Cart;
import com.ShoppingCart.Web.model.Items;
import com.ShoppingCart.Web.repository.CartRepository;


@Service
@Transactional
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	
	public Cart getCart(int id) {
		return cartRepository.findByCartId(id);
	}
	
	public void addCart(int id) {
		if(getCart(id)==null) {
			Cart cart = new Cart();
			cart.setCartId(id);
			List<Items> item = new ArrayList<Items>();
			cart.setItems(item);
			cartRepository.save(cart);
		}
	}


	

}
