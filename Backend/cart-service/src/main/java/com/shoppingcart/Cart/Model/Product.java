package com.shoppingcart.Cart.Model;


import java.util.List;
import java.util.Map;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


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
