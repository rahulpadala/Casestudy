package com.ShoppingCart.Web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ShoppingCart.Web.model.AuthRequest;
import com.ShoppingCart.Web.model.AuthResponse;
import com.ShoppingCart.Web.model.userProfile;
import com.ShoppingCart.Web.repository.userProfileRepository;
import com.ShoppingCart.Web.util.JwtUtil;

//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Map;

@Service
@Transactional
public class UserService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private userProfileRepository userRepository;


    //Generates token
    public ResponseEntity<?> generateToken(AuthRequest authRequest) throws Exception {
        try {
            //Verifying email and password
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmailId(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid email or password");
        }

        //Generate token
        String token = jwtUtil.generateToken(authRequest.getEmailId());
        userProfile user = userRepository.findByEmailId(authRequest.getEmailId());

        //Response
        return ResponseEntity.status(HttpStatus.OK)
                .body(new AuthResponse(token, user));
    }

  

}
