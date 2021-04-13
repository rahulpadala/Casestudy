package com.ShoppingCart.Web.model;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Users")
public class userProfile {
	
	@Id
	private int profileId;
	private String fullName ;
	private String image;
	private String emailId;
	private Long mobileNumber;
	private String about;
	private LocalDate dateOfBirth;
	private String gender;
	private String role;
	private String password;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public userProfile(int profileId, String fullName, String image, String emailId, Long mobileNumber, String about,
			LocalDate dateOfBirth, String gender, String role, String password) {
	
		this.profileId = profileId;
		this.fullName = fullName;
		this.image = image;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.about = about;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.role = role;
		this.password = password;
	}
	public userProfile() {
		
	}
	@Override
	public String toString() {
		return "userProfile [profileId=" + profileId + ", fullName=" + fullName + ", image=" + image + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", about=" + about + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", role=" + role + ", password=" + password + "]";
	}
	
	
	
	

	
}
