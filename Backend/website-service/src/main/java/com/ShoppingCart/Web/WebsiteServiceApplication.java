package com.ShoppingCart.Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;

//import java.util.Arrays;


@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@PropertySource("classpath:application.properties")
public class WebsiteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteServiceApplication.class, args);
	}

}
