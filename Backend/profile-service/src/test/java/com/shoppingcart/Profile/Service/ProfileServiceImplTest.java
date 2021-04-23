package com.shoppingcart.Profile.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoppingcart.Profile.Model.userProfile;
import com.shoppingcart.Profile.Repository.ProfileRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProfileServiceImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Autowired
	private ProfileService profileService;

	@MockBean
	private ProfileRepository profileRepository;

	@Test
	void testAddNewCustomerProfile() {
		userProfile user = new userProfile(1,"Rahul","abc@xyz","abc.xyz", 99999L , "abc" , null , "male", null, "abcd123");
		when(profileRepository.save(user)).thenReturn(user);
		assertEquals(user, profileService.addNewCustomerProfile(user));
	}
	//
	@Test
	void testAddNewMerchantProfile() {
		userProfile user = new userProfile(1,"Rahul","abc@xyz","abc.xyz", 99999L , "abc" , null, "male", null, "abcd123");
		profileService.addNewMerchantProfile(user);
		verify(profileRepository,times(1)).save(user);
	}

	@Test
	void testAddDeliveryAgentProfile() {
		userProfile user = new userProfile(1,"Rahul","abc@xyz","abc.xyz", 99999L , "abc" , null, "male", null, "abcd123");
		profileService.addDeliveryAgentProfile(user);
		verify(profileRepository,times(1)).save(user);
	}

	@Test
	void testGetAllProfiles() {
		when(profileRepository.findAll()).thenReturn(Stream.of(new userProfile(1,"Rahul","abc.jpg","abc@xyz",null, "90000", null, null, null, null),new userProfile(2,"Reddy","def.jpg","abcd@xyz",null, "90010", null, null, null, null)).collect(Collectors.toList()));
		assertEquals(2, profileService.getAllProfiles().size());
	}

	@Test
	void testGetProfileById() 
	{
		int id=1;
		profileRepository.findById(id);
		verify(profileRepository,times(1)).findById(id);
	}

	@Test
	void testGetProfileByMobile() {
		userProfile user = new userProfile(2,"Reddy","def.jpg","abcd@xyz",90000L, null, null, null, null, null);
		long mobileNumber = 90000L;
		when(profileRepository.findByMobileNumber(mobileNumber)).thenReturn(user);
		assertEquals(user, profileService.getProfileByMobile(mobileNumber));
	}

	@Test
	void testUpdateUserProfile() {
		userProfile user = new userProfile(1,"Rahul","abc@xyz","abc.xyz", 99999L , "abc" , null, "male", null, "abcd123");
		profileRepository.save(user);
		verify(profileRepository,times(1)).save(user);
	}

}
