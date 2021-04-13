package com.ShoppingCart.Web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShoppingCart.Web.model.userProfile;
import com.ShoppingCart.Web.service.ProfileService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("token")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    
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
