 package com.shoppingcart.Order.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Address> getAddByCustomerId(int id) {
		return addressRepository.findByCustomerId(id);
	}

	@Override
	public Orders findMaxByOrderId() {
		return orderRepository.findFirstByOrderByOrderIdDesc();
	}

	@Override
	public void placeOrder(Cart cart) {
		//Address
		Orders order = new Orders();
		Address address = new Address();
		List<Product> products = new ArrayList<Product>();
		
		order.setCustomerId(cart.getCartId());
		order.setOrderStatus("Ordered");
		order.setQuantity(cart.getItems().size());
		order.setAddress(address);
		for(int i=0;i<cart.getItems().size();i++)
		{
			Product product = new Product();
			product.setProductId(""+(i+1));
			product.setProductName(cart.getItems().get(i).getProductName());
			products.add(product);
		}
		order.setProduct(products);
		order.setOrderDate(java.time.LocalDate.now());
		orderRepository.save(order);
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


