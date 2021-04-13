package com.shoppingcart.Profile.Resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.Profile.Model.userProfile;
import com.shoppingcart.Profile.Service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileResource {
	
	@Autowired
	private ProfileService profileService;

	@PostMapping("/addCustomer")
	public userProfile addNewCustomerProfile(@RequestBody userProfile uP){
		return profileService.addNewCustomerProfile(uP);
	}
	
	@PostMapping("/addMerchant")
	public void addNewMerchantProfile(@RequestBody userProfile uP) {
		profileService.addNewMerchantProfile(uP);
	}
	
	@PostMapping("/addDeliveryAgent")
	public void addDeliveryAgentProfile(@RequestBody userProfile uP) {
	    profileService.addDeliveryAgentProfile(uP);
	}
	
	@GetMapping("/viewAllUsers")
	public List<userProfile> getAllProfiles()
	{
		return profileService.getAllProfiles();
	}
	
	@GetMapping("/viewUserById/{id}")
	public Optional<userProfile> getProfileById(@PathVariable("id") int Id) {
		return profileService.getProfileById(Id);
	}
	
	@GetMapping("/viewUserByMobile/{mobile}")
	public userProfile getProfileByMobile(@PathVariable("mobile") long mobileNumber) {
		return profileService.getProfileByMobile(mobileNumber);
	}
	
	@PutMapping("/updateProfile")
	public void updateUserProfile(@RequestBody userProfile uP)
	{
		profileService.updateUserProfile(uP);
	}
	
	@DeleteMapping("/deleteProfile/{id}")
	public void deleteProfileById(@PathVariable("id") int Id)
	{
		profileService.deleteProfileById(Id);;
	}
	

	
	
	
	
	
}
