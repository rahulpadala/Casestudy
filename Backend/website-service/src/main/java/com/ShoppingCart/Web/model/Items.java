package com.ShoppingCart.Web.model;

public class Items {
	
	private String ProductName;
	private int productId;
	private String productType;
	private String image;
	private double price;
	private int quantity;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public Items(String productName, int productId, String productType, String image, double price, int quantity) {
		super();
		ProductName = productName;
		this.productId = productId;
		this.productType = productType;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
	}
	public Items() {
		
	}
	@Override
	public String toString() {
		return "Items [ProductName=" + ProductName + ", productId=" + productId + ", productType=" + productType
				+ ", image=" + image + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}


