package com.shoppingcart.Cart.Model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Carts")
public class Cart {
	
	@Id
	private int cartId;
	private double totalPrice = 0;
	private List<Items> items;
	
}
