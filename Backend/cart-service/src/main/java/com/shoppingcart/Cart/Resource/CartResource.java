package com.shoppingcart.Cart.Resource;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.Cart.Model.Cart;
import com.shoppingcart.Cart.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartResource {

	@Autowired 
	private CartService cartService;

//	@GetMapping("/viewAllProducts")
//	public ResponseEntity<Products> getAllProducts(){
//		return cartService.getAllProducts();
//	}

	@GetMapping("/getAllCarts")
	public ResponseEntity<List<Cart>> getAllCarts(){
		return new ResponseEntity<List<Cart>>(cartService.getAllCarts(),HttpStatus.OK);
	}

	@PostMapping("/addCart/{id}")
	public void addCart(@PathVariable("id") int id) {
		cartService.addCart(id);
	}

	@GetMapping("/getCartById/{id}")
	public Cart getCartById(@PathVariable("id") int id){
		return cartService.getCartById(id);
	}

	@PostMapping("updateCart/{cid}/{id}")
	public void updateCart(@PathVariable("cid") int cid,@PathVariable("id") int id){
		cartService.updateCart(cid, id);;
	}
	
	@PostMapping("addToCart/{cartId}/{productId}")
	public void addToCart(@PathVariable("cartId") int cId,@PathVariable("productId") int pId) {
		cartService.addToCart(cId,pId);
	}
	

	
}

