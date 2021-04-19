package com.shoppingcart.Cart.Model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products")
public class Product {
	
	@Transient
    public static final String SEQUENCE_NAME = "products_sequence";
	
	@Id
	private int productId;
	private String productType;
	private String productName;
	private String category;
	private Map<Integer,Double> rating;
	private Map<Integer,String> review;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private double price;
	private String description;
	private Map<String,String> specification;
	
	
	
	
	

}
