package com.shoppingcart.Cart.Service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shoppingcart.Cart.Exception.InputErrorException;
import com.shoppingcart.Cart.Exception.ResourceNotFoundException;
import com.shoppingcart.Cart.Model.Cart;
import com.shoppingcart.Cart.Model.Items;
import com.shoppingcart.Cart.Model.Product;
import com.shoppingcart.Cart.Repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	

//	@Override
//	public ResponseEntity<Products> getAllProducts() {
//		//HttpHeaders header = new HttpHeaders();
//		//header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		//HttpEntity<Products> entity = new HttpEntity<Products>(header);
//		ResponseEntity<Products> result = restTemplate.getForEntity("http://Product-Service/product/viewAllProducts", Products.class);
//		return result;
//		
//	}

	@Override
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public void addCart(int id) {
//		if(cartRepository.findByCartId(id)!=null)
//		{
//			throw new InputErrorException("Cart Already Exists with the ID "+id);
//		}
		Cart cart = new Cart();
		cart.setCartId(id);
		List<Items> item = new ArrayList<Items>();
		cart.setItems(item);
		cartRepository.save(cart);
	}

	@Override
	public Cart getCartById(int id) {
//		if(cartRepository.findByCartId(id)==null)
//		{
//			throw new ResourceNotFoundException("Cart Not Found with Id "+id);
//		}
		return cartRepository.findByCartId(id);
	}

	@Override
	public Cart updateCart(Cart cart) {
		if(cartRepository.findByCartId(cart.getCartId())==null)
		{
			throw new InputErrorException("Cart Not Found with Id "+cart.getCartId());
		}
		return cartRepository.save(cart);
	}

	@Override
	public void addToCart(int cId, int pId) {
		if(cartRepository.findByCartId(cId)==null)
		{
			throw new ResourceNotFoundException("Cart Not Found with Id "+cId);
		}
		Cart cart = getCartById(cId);
		Items items = new Items();
		boolean exists = false;
		int i=0;
		ResponseEntity<Product> re = restTemplate.getForEntity("http://Product-Service/product/viewProductById/{id}", Product.class,pId);
		if(re==null)
		{
			throw new ResourceNotFoundException("Product Not Found with Id "+pId);
		}
		for(i=0;i<cart.getItems().size();i++)
		{
			if(cart.getItems().get(i).getProductId()==pId)
			{
				exists = true;
				break;
			}
		}
		
		if(!exists)
		{
			items.setProductName(re.getBody().getProductName());
			items.setProductId(re.getBody().getProductId());
			items.setImage(re.getBody().getImage().get(0));
			items.setPrice(re.getBody().getPrice());
			items.setQuantity(1);
			cart.getItems().add(items);
			cartRepository.save(cart);
			return;
		} 
		
		cart.getItems().get(i).setQuantity(cart.getItems().get(i).getQuantity()+1);
		cartRepository.save(cart);
		
//		System.out.println(cart.getItems().size());
//		System.out.println(cart.getItems().get(0).getProductName());
//		int tc = 0;
//		for(int i=0;i<cart.getItems().size();i++)
//		{
//			tc += cart.getItems().get(i).getPrice();
//		}
//		System.out.println(tc);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
