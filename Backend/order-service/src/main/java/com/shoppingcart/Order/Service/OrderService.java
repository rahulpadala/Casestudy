package com.shoppingcart.Order.Service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.Order.Model.Address;
import com.shoppingcart.Order.Model.Cart;
import com.shoppingcart.Order.Model.Orders;

public interface OrderService {

	List<Orders> getAllOrders();

	List<Address> getAllAddress();

	List<Orders> getOrderByCustomerId(int id);

	List<Address> getAddByCustomerId(int id);

	Orders findMaxByOrderId();

	void placeOrder(Cart cart);

	Optional<Orders> getOrderByOrderId(int id);

	void storeAddress(Address address);

	void changeOrderStatus(String status, int id);

	String deleteOrder(int id);

}
