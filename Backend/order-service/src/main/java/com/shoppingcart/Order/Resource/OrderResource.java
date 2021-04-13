package com.shoppingcart.Order.Resource;

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

import com.shoppingcart.Order.Model.Address;
import com.shoppingcart.Order.Model.Cart;
import com.shoppingcart.Order.Model.Orders;
import com.shoppingcart.Order.Service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderResource {

	@Autowired
	private OrderService orderService;


	@GetMapping("/viewAllOrders")
	public List<Orders> getAllOrders()
	{
		return orderService.getAllOrders();
	}

	@GetMapping("/viewAllAddress")
	public List<Address> getAllAddress()
	{
		return orderService.getAllAddress();
	}

	@GetMapping("/getOrderByCustomerId/{id}")
	public List<Orders> getOrderByCustomerId(@PathVariable("id") int id)
	{
		return orderService.getOrderByCustomerId(id);
	}

	@GetMapping("/getAddByCustomerId/{id}")
	public List<Address> getAddByCustomerId(@PathVariable("id") int id)
	{
		return orderService.getAddByCustomerId(id);
	}

	@GetMapping("/findMaxByOrderId")
	public Orders findMaxByOrderId()
	{
		return orderService.findMaxByOrderId();
	}

	@PostMapping("/placeOrder")
	public void placeOrder(@RequestBody Cart cart)
	{
		orderService.placeOrder(cart);
	}


	//	public void onlinePayment(@RequestBody Cart cart) {
	//		
	//	}

	@GetMapping("getOrderByOrderId/{id}")
	public Optional<Orders> getOrderByOrderId(@PathVariable("id") int id)
	{
		return orderService.getOrderByOrderId(id);
	}

	@PostMapping("storeAddress")
	public void storeAddress(@RequestBody Address address)
	{
		orderService.storeAddress(address);
	}

	@PutMapping("/changeOrderStatus/{id}")
	public void changeOrderStatus(String status,@PathVariable("id") int id) 
	{
		orderService.changeOrderStatus(status,id);
	}

	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") int id)
	{
		return new ResponseEntity<String>(orderService.deleteOrder(id),HttpStatus.OK);
	}






}
