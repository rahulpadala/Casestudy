package com.shoppingcart.Product.Model;


import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Products")
public class Product {
	
	@Id
	private int productId;
	private String productType;
	private String productName;
	private String category;
	private Map<Integer,Double> rating;
	private Map<Integer,String> review;
	private List<String> image;
	private double price;
	private String description;
	private Map<String,String> specification;
	
	
	
	
	

}
