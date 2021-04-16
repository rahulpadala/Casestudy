package com.shoppingcart.Order.Model;


public class Product {
	
	private int productId;
	private String productName;
	
	public Product(int productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}
	public Product() {
	
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + "]";
	}
	
	
	

}
