package com.shoppingcart.Cart.Model;

import java.util.List;


public class Products {
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Products(List<Product> products) {
			this.products = products;
	}
	
	public Products() {
		
	}



}
