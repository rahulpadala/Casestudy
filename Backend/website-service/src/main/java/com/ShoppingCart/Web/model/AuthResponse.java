package com.ShoppingCart.Web.model;



public class AuthResponse {
    private String token;
    private userProfile user;
    
    
	public AuthResponse(String token, userProfile user) {
		this.token = token;
		this.user = user;
	}
	
	public AuthResponse() {
		
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public userProfile getUser() {
		return user;
	}
	public void setUser(userProfile user) {
		this.user = user;
	}
    
    
}
