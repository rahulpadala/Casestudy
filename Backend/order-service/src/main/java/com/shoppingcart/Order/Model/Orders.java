package com.shoppingcart.Order.Model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
public class Orders {
	
	@Id
	private String orderId;
	
	private LocalDate orderDate;
	private int customerId;
	private double amount;
	private String modeOfPayment;
	private String orderStatus;
	private int quantity;
	private Address address;
	private List<Product> product;
	
	
	
	public Orders(String orderId, LocalDate orderDate, int customerId, double amountPaid, String modeOfPayment,
			String orderStatus, int quantity, Address address, List<Product> product) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.amount = amountPaid;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.address = address;
		this.product = product;
	}
	
	
	public Orders() {
	
	}


	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", amount=" + amount + ", modeOfPayment=" + modeOfPayment + ", orderStatus=" + orderStatus
				+ ", quantity=" + quantity + ", address=" + address + ", product=" + product + "]";
	}
	
	
	
	
	
	

}
