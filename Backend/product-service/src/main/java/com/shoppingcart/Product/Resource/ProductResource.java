package com.shoppingcart.Product.Resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.Product.Model.Product;
//import com.shoppingcart.Product.Model.Products;
import com.shoppingcart.Product.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public void addProducts(@RequestBody Product pro)
	{
		productService.addProducts(pro);
	}
	
	@GetMapping("/viewAllProducts")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	@GetMapping("/viewProductById/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") int id){
		return new ResponseEntity<Optional<Product>>(productService.getProductById(id),HttpStatus.OK);
	}
	
	@GetMapping("/viewProductByType/{type}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable("type") String type){
		return new ResponseEntity<List<Product>>(productService.getProductByType(type),HttpStatus.OK);
	}
	
	@GetMapping("/viewProductByName/{name}")
	public ResponseEntity<Optional<Product>> getProductByName(@PathVariable("name") String name){
		return new ResponseEntity<Optional<Product>>(productService.getProductByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/viewProductByCategory/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category){
		return new ResponseEntity<List<Product>>(productService.getProductByCategory(category),HttpStatus.OK);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product pro)
	{
		return new ResponseEntity<Product>(productService.updateProduct(pro),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMapping/{id}")
	public void deleteProductById(@PathVariable("id") int id)
	{
		productService.deleteProductById(id);
	}
	
	
	
	

}
