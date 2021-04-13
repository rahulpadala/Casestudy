package com.shoppingcart.Profile.Service;



import java.util.List;
import java.util.Optional;

import com.shoppingcart.Profile.Model.userProfile;



public interface ProfileService {

	
	userProfile addNewCustomerProfile(userProfile uP);

	void addNewMerchantProfile(userProfile uP);

	void addDeliveryAgentProfile(userProfile uP);

	List<userProfile> getAllProfiles();

	Optional<userProfile> getProfileById(int id);

	userProfile getProfileByMobile(long mobileNumber);

	void updateUserProfile(userProfile uP);

	void deleteProfileById(int id);

	
	
	
	
}
