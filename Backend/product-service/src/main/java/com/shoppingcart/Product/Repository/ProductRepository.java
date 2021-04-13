package com.shoppingcart.Product.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.Product.Model.Product;


public interface ProductRepository extends MongoRepository<Product, Integer>{
	
	public Optional<Product> findByProductName(String productName);
	public List<Product> findByCategory(String category);
	public List<Product> findByProductType(String productType);
	

}
