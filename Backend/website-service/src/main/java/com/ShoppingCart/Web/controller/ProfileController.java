package com.ShoppingCart.Web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShoppingCart.Web.model.Cart;
import com.ShoppingCart.Web.model.userProfile;
import com.ShoppingCart.Web.service.CartService;
import com.ShoppingCart.Web.service.ProfileService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("token")
public class ProfileController {
	@Autowired
	private ProfileService profileService;

	@Autowired
	private CartService cartService;

	//    @GetMapping("/test")
	//    public String geti(HttpServletRequest request) {
	//    	return (String) request.getAttribute("id");
	//    }

	@GetMapping("/user")
	public ResponseEntity<?> getUser(HttpServletRequest request) {
		try {
			String id = (String) request.getAttribute("id");
			return profileService.getUser(Integer.valueOf(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(Map.of("message", e.getMessage()));
		}
	}

	@PostMapping("/cart")
	public void generateCart(HttpServletRequest request){
		try {
			String id = (String) request.getAttribute("id");
			String role = (String) request.getAttribute("role");
			if(role.equals("Customer"))
			{
				int profileId = Integer.valueOf(id);
				cartService.addCart(profileId);	
			}
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.OK)
			.body(Map.of("message", e.getMessage()));
		}
	}
	
	@GetMapping("/cart")
	public Cart getCart(HttpServletRequest request) throws Exception {
		try {
			String id = (String) request.getAttribute("id");
			int cid = Integer.valueOf(id);
			return cartService.getCart(cid);
		} catch (Exception e) {
			throw new Exception("Error while Getting Cart");
		}
	}



	@DeleteMapping("/user")
	public ResponseEntity<?> deleteUser(HttpServletRequest request) {
		try {
			String id = (String) request.getAttribute("id");
			return profileService.deleteUser(Integer.valueOf(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(Map.of("message", e.getMessage()));
		}
	}

	@PutMapping("/user")
	public ResponseEntity<?> updateUser(HttpServletRequest request, @RequestBody userProfile user) {
		try {
			String id = (String) request.getAttribute("id");
			return profileService.updateUser(Integer.valueOf(id), user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(Map.of("message", e.getMessage()));
		}
	}
}
