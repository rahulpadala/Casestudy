package com.ShoppingCart.Web.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ShoppingCart.Web.filter.JwtFilter;
import com.ShoppingCart.Web.service.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/login/authenticate").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/swagger-ui").permitAll()
                .antMatchers("/profile/addCustomer","/profile/addMerchant","/profile/addDeliveryAgent").permitAll()
                .antMatchers("/product/viewAllProducts","/product/viewProductById/{id}").permitAll()
                .antMatchers("/product/viewProductByType/{type}","/product/viewProductByName/{name}","/product/viewProductByCategory/{category}").permitAll()
                .antMatchers("/token/user").permitAll()
                .antMatchers("/product/addProduct","/product/updateProduct","/product/deleteProduct/{id}").hasAuthority("Merchant")
                .antMatchers("/token/cart").hasAuthority("Customer")
                .antMatchers("/cart/**").hasAuthority("Customer")
                .antMatchers("/order/viewAllOrders","/order/changeOrderStatus/{id}","/order/getOrderByOrderId/{id}").hasAuthority("DeliveryAgent")
                .antMatchers("/order/getOrderByCustomerId/{id}","/order/getAddByCustomerId/{id}","/order/placeOrder/{id}","/order/deleteOrder/{id}","/order/storeAddress","/order/getOrderByOrderId/{id}").hasAuthority("Customer")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
