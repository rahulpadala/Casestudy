package com.shoppingcart.Profile.Model;

import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
public class userProfile {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
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

	
}
