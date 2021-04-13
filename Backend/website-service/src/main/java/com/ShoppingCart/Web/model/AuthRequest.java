package com.ShoppingCart.Web.model;




public class AuthRequest {
    private String emailId;
    private String password;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthRequest(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
	public AuthRequest() {
		
	}
	
	
    
	
	
    
}
