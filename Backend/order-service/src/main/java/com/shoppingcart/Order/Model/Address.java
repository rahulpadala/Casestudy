package com.shoppingcart.Order.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Address")
public class Address {
	
	@Id
	private int customerId;
	private String fullName;
	private String mobileNumber;
	private int flatNumber;
	private String city;
	private int pincode;
	private String state;
	
	
	public Address(int customerId, String fullName, String mobileNumber, int flatNumber, String city, int pincode,
			String state) {
		this.customerId = customerId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.flatNumber = flatNumber;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}
	
	
	public Address() {
		
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Address [customerId=" + customerId + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
				+ ", flatNumber=" + flatNumber + ", city=" + city + ", pincode=" + pincode + ", state=" + state + "]";
	}
	
	

}
