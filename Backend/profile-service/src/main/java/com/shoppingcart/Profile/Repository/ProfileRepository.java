package com.shoppingcart.Profile.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.shoppingcart.Profile.Model.userProfile;

public interface ProfileRepository extends MongoRepository<userProfile, Integer>{
	
	public userProfile findByMobileNumber(long mobileNumber);
	public userProfile findByEmailId(String emailId);
		
	}
	


