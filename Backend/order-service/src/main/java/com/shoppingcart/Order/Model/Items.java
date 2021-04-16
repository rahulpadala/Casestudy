package com.shoppingcart.Order.Model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
	
	private String ProductName;
	private int productId;
	private String image;
	private double price;
	private int quantity;
	
}
