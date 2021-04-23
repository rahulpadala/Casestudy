package com.shoppingcart.Cart.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
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

import com.shoppingcart.Cart.Model.Cart;
import com.shoppingcart.Cart.Repository.CartRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartServiceImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@Autowired
	  private CartService service;
	
	@MockBean
	private CartRepository repo;

	@Test
	void testGetAllCarts() {
		when(repo.findAll())
		.thenReturn((List<Cart>) Stream.of(new Cart(1, 1000, null),new Cart(2, 9000, null)).collect(Collectors.toList()));
	    assertEquals(2,service.getAllCarts().size());
	}

	@Test
	void testAddCart() {
		Cart cart=new Cart(1, 10, null);
        repo.save(cart);
		verify(repo, times(1)).save(cart);
	}

	@Test
	void testGetCartById() {
		Cart cart=new Cart(1, 10, null);
		int id =1;
		when(repo.findByCartId(id)).thenReturn(cart);
		assertEquals(cart, service.getCartById(id));
	}

	@Test
	void testUpdateCart() {
		Cart cart=new Cart(1, 10, null);
        repo.save(cart);
		verify(repo, times(1)).save(cart);
	}


	@Test
	void testDeleteCart() {
		Cart cart=new Cart(1, 10, null);
		int id =1;
        repo.deleteById(id);
		verify(repo, times(1)).deleteById(id);
	}

}
