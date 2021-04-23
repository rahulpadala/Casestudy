package com.shoppingcart.Product.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoppingcart.Product.Model.Product;
import com.shoppingcart.Product.Repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;

	@Test
	void testAddProducts() {
		Product product = new Product(1,"watch","watch","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null);
		productService.addProducts(product);
		verify(productRepository,times(1)).save(product);
	}

	@Test
	void testGetAllProducts() {
		when(productRepository.findAll())
		.thenReturn(Stream.of(new Product(1,"Rolex watch","watch","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null),new Product(1,"Dell ","laptop","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null)).collect(Collectors.toList()));
		assertEquals(2,productService.getAllProducts().size());
	}

	@Test
	void testGetProductById() {
		int id=1;
		productRepository.findById(id);
		verify(productRepository,times(1)).findById(id);
	}

	@Test
	void testGetProductByType() {
		String type = "watch";
		when(productRepository.findByProductType(type))
		.thenReturn(Stream.of(new Product(1,"Rolex watch","watch","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null),new Product(1,"Dell ","laptop","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null)).collect(Collectors.toList()));
		assertEquals(2,productService.getProductByType(type).size());
	}

	@Test
	void testGetProductByName() {
		String name = "Watch";
		productRepository.findByProductName(name);
		verify(productRepository,times(1)).findByProductName(name);
	}

	@Test
	void testGetProductByCategory() {
		String category = "Electronic";
		when(productRepository.findByCategory(category))
		.thenReturn(Stream.of(new Product(1,"Rolex watch","watch","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null),new Product(1,"Dell ","laptop","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null)).collect(Collectors.toList()));
		assertEquals(2,productService.getProductByCategory(category).size());
	}

	@Test
	void testUpdateProduct() {
		Product product = new Product(1,"watch","watch","Electronic", null, null, "abc.jpg", "bcd.jpg", "def.jpg", "ghi.jpg", 0, "description", null);
		productRepository.save(product);
		verify(productRepository,times(1)).save(product);	
	}
}


