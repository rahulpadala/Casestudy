package com.ShoppingCart.Web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ShoppingCart.Web.model.userProfile;
import com.ShoppingCart.Web.repository.userProfileRepository;
import com.ShoppingCart.Web.util.MyUserDetails;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private userProfileRepository userprofilerepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        email = email.toLowerCase();
        userProfile user = userprofilerepo.findByEmailId(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetails(user);
    }
}
