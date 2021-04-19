 package com.shoppingcart.Order.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shoppingcart.Order.Model.Address;
import com.shoppingcart.Order.Model.Cart;
import com.shoppingcart.Order.Model.Orders;
import com.shoppingcart.Order.Model.Product;
import com.shoppingcart.Order.Repository.AddressRepository;
import com.shoppingcart.Order.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;


	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	@Override
	public List<Orders> getOrderByCustomerId(int id) {
		return orderRepository.findByCustomerId(id);
	}

	@Override
	public Optional<Address> getAddByCustomerId(int id) {
		return addressRepository.findById(id);
	}

	@Override
	public Orders findMaxByOrderId() {
		return orderRepository.findFirstByOrderByOrderIdDesc();
	}

	@Override
	public void placeOrder(int id, Address address) {
		//Address
		Orders order = new Orders();
		List<Product> products = new ArrayList<Product>();
		ResponseEntity<Cart> cart = restTemplate.getForEntity("http://Cart-Service/cart/getCartById/{id}", Cart.class,id);
		order.setCustomerId(cart.getBody().getCartId());
		order.setAmount(cart.getBody().getTotalPrice());
		order.setOrderStatus("Ordered");
		order.setQuantity(cart.getBody().getItems().size());
		order.setAddress(address);
		for(int i=0;i<cart.getBody().getItems().size();i++)
		{
			Product product = new Product();
			product.setProductId(cart.getBody().getItems().get(i).getProductId());
			product.setProductName(cart.getBody().getItems().get(i).getProductName());
			products.add(product);
		}
		order.setProduct(products);
		order.setOrderDate(java.time.LocalDate.now());
		orderRepository.save(order);
		restTemplate.delete("http://Cart-Service/cart/deleteCart/{id}",id);
	}

	@Override
	public Optional<Orders> getOrderByOrderId(int id) {
		return orderRepository.findById(id);
	}

	@Override
	public void storeAddress(Address address) {
		addressRepository.save(address);
	}

	@Override
	public void changeOrderStatus(String status, int id) {
		orderRepository.findById(id).get().setOrderStatus(status);
	}

	@Override
	public String deleteOrder(int id) {
		orderRepository.deleteById(id);
		return "Order Deleted";
	}

}


