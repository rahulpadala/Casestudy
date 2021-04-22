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

	Optional<Address> getAddByCustomerId(int id);

	Orders findMaxByOrderId();

	void placeOrder(int id, Address address);

	Orders getOrderByOrderId(String id);

	void storeAddress(Address address);

	void changeOrderStatus(String status, String id);

	String deleteOrder(String id);

	void changePaymentMethod(String method, String id);

}
