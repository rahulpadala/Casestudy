package com.shoppingcart.Profile.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoppingcart.Profile.Exception.InputErrorException;
import com.shoppingcart.Profile.Exception.ResourceNotFoundException;
import com.shoppingcart.Profile.Model.Role;
import com.shoppingcart.Profile.Model.userProfile;
import com.shoppingcart.Profile.Repository.ProfileRepository;


@Service
public class ProfileServiceImpl implements ProfileService,Role{
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; 
	
	@Override
	public userProfile addNewCustomerProfile(userProfile uP){
		if(profileRepository.findByEmailId(uP.getEmailId())!=null) {
			throw new InputErrorException("Customer Already Exists with email Id "+uP.getEmailId());
		}
		if(profileRepository.findByMobileNumber(uP.getMobileNumber())!=null) {
			throw new InputErrorException("Customer Already Exists with Mobile Number "+uP.getMobileNumber());
		}
		uP.setRole(Customer);
		uP.setPassword(passwordEncoder.encode(uP.getPassword()));
		return profileRepository.save(uP);	
	}

	@Override
	public void addNewMerchantProfile(userProfile uP){
		if(profileRepository.findByEmailId(uP.getEmailId())!=null) {
			throw new InputErrorException("Merchant Already Exists with email Id "+uP.getEmailId());
		}
		if(profileRepository.findByMobileNumber(uP.getMobileNumber())!=null) {
			throw new InputErrorException("Merchant Already Exists with Mobile Number "+uP.getMobileNumber());
		}
		uP.setRole(Merchant);
		uP.setPassword(passwordEncoder.encode(uP.getPassword()));
		profileRepository.save(uP);
		
	}

	@Override
	public void addDeliveryAgentProfile(userProfile uP){
		if(profileRepository.findByEmailId(uP.getEmailId())!=null) {
			throw new InputErrorException("Delivery Agent Already Exists with email Id "+uP.getEmailId());
		}
		if(profileRepository.findByMobileNumber(uP.getMobileNumber())!=null) {
			throw new InputErrorException("Delivery Agent Already Exists with Mobile Number "+uP.getMobileNumber());
		}
		uP.setRole(DeliverAgent);
		uP.setPassword(passwordEncoder.encode(uP.getPassword()));
		profileRepository.save(uP);
	}

	@Override
	public List<userProfile> getAllProfiles(){
		if(profileRepository.findAll().size()==0)
		{
			throw new InputErrorException("Currently No users were registered.");
		}
		return profileRepository.findAll();
	}

	@Override
	public Optional<userProfile> getProfileById(int id){
		return Optional.ofNullable(profileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No profile found with Id "+id)));
	}

	@Override
	public userProfile getProfileByMobile(long mobileNumber) {
		if(profileRepository.findByMobileNumber(mobileNumber)==null)
		{
			throw new ResourceNotFoundException("No profile found with Mobile Number "+mobileNumber);
		}
		return profileRepository.findByMobileNumber(mobileNumber);
	}

	@Override
	public void updateUserProfile(userProfile uP) {
		if(profileRepository.findByEmailId(uP.getEmailId())==null){
			throw new InputErrorException("No User found to update with Email Id "+uP.getEmailId());
		}
		uP.setPassword(passwordEncoder.encode(uP.getPassword()));
		profileRepository.save(uP);
	}

	@Override
	public void deleteProfileById(int id) {
		if((profileRepository.findById(id)).isEmpty())
		{
			throw new ResourceNotFoundException("No User found to delete with Id "+id);
		}
		profileRepository.deleteById(id);
	}
}