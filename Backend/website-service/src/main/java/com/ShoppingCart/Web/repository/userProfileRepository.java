package com.ShoppingCart.Web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ShoppingCart.Web.model.userProfile;

public interface userProfileRepository extends MongoRepository<userProfile, Integer>  {
	public userProfile findByEmailId(String emailId);
}
