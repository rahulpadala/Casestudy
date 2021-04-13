package com.shoppingcart.Product.Service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.Product.Model.Product;
//import com.shoppingcart.Product.Model.Products;


public interface ProductService {

	void addProducts(Product pro);

	List<Product> getAllProducts();

	Optional<Product> getProductById(int id);

	List<Product> getProductByType(String type);

	Optional<Product> getProductByName(String name);

	List<Product> getProductByCategory(String category);

	Product updateProduct(Product pro);

	void deleteProductById(int id);
	
	
	
	
	

}
