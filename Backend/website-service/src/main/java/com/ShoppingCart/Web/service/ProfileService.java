package com.ShoppingCart.Web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ShoppingCart.Web.model.userProfile;
import com.ShoppingCart.Web.repository.userProfileRepository;

import java.util.Map;

@Service
@Transactional
public class ProfileService {
    @Autowired
    private userProfileRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Get user details
    public ResponseEntity<?> getUser(int id) throws Exception {
        //Fetch user from DB
        userProfile user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("No user found"));

        //Response
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);
    }

    //Delete user details
    public ResponseEntity<?> deleteUser(int id) throws Exception {
        //Fetch user from DB
        userRepository.findById(id)
                .orElseThrow(() -> new Exception("No user found"));

        try {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("message", "User deleted successfully of id: " + id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Update user details
    public ResponseEntity<?> updateUser(int id, userProfile user) throws Exception {
       
        //check whether user exists
        userProfile userFromId = userRepository.findById(id)
                .orElseThrow(() -> new Exception("No user found"));
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));

       

        //Save data to DB
        try {
            userRepository.save(userFromId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Map.of("message", "User details are updated successfully with id: "
                            + id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }
    
    
}
