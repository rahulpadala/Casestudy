package com.shoppingcart.Product.Service;

import java.util.List;
import java.util.Optional;
//import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shoppingcart.Product.Exception.InputErrorException;
import com.shoppingcart.Product.Exception.ResourceNotFoundException;
import com.shoppingcart.Product.Model.Product;
//import com.shoppingcart.Product.Model.Products;
import com.shoppingcart.Product.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void addProducts(Product pro) {
		if(productRepository.findById(pro.getProductId())!=null && !productRepository.findById(pro.getProductId()).isEmpty())
		{
			throw new InputErrorException("Product Already Exists with the Product Id "+pro.getProductId());
		}
		if(productRepository.findByProductName(pro.getProductName())!=null && !productRepository.findByProductName(pro.getProductName()).isEmpty())
		{
			throw new InputErrorException("Product Already Exists with the Product Name "+pro.getProductName());
		}
		productRepository.save(pro);
	}


	@Override
	public List<Product> getAllProducts() {
//		Products products = new Products(productRepository.findAll());
//		return products;
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		return Optional.ofNullable(((productRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product not found with the ID "+id)))));
	}


	@Override
	public List<Product> getProductByType(String type) {
		return productRepository.findByProductType(type);
	}


	@Override
	public Optional<Product> getProductByName(String name) {
		return Optional.ofNullable(((productRepository.findByProductName(name).orElseThrow(() ->new ResourceNotFoundException("Product not found with the Name "+name)))));
	}


	@Override
	public List<Product> getProductByCategory(String category) {
		return productRepository.findByCategory(category);
	}


	@Override
	public Product updateProduct(Product pro) {
		if(productRepository.findById(pro.getProductId())==null)
		{
			throw new ResourceNotFoundException("Product is not Found to Update with Id "+pro.getProductId());
		}
		return productRepository.save(pro);
	}


	@Override
	public void deleteProductById(int id) {
		if(productRepository.findById(id)==null)
		{
			throw new ResourceNotFoundException("Product is not Found to Delete with Id "+id);
		}
		productRepository.deleteById(id);
	}
	
	
	

}
