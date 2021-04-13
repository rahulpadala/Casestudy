package com.shoppingcart.Order.Model;

import java.util.List;



public class Cart {
	

	private int cartId;
	private double totalPrice;
	private List<Items> items;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public Cart(int cartId, double totalPrice, List<Items> items) {

		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.items = items;
	}
	public Cart() {

	}
	
	
	
	
}
