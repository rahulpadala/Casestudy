package com.shoppingcart.Order.Model;

public class Items {
	
	private String ProductName;
	private double price;
	private int quantity;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Items(String productName, double price, int quantity) {
		
		ProductName = productName;
		this.price = price*quantity;
		this.quantity = quantity;
	}
	public Items() {

	}
	@Override
	public String toString() {
		return "Items [ProductName=" + ProductName + "]";
	}
	
	

}
