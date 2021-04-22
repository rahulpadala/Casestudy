package com.shoppingcart.Profile.Model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
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
	@NotNull
	private String fullName ;
	
	private String image;
	
	@NotNull
	private String emailId;
	
	@NotNull
	private Long mobileNumber;
	
	private String about;
	
	@NotNull
	private LocalDate dateOfBirth;
	
	@NotNull
	private String gender;
	
	private String role;
	
	@NotNull
	private String password;

	
}
