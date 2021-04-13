package com.shoppingcart.Profile.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class InputErrorException extends RuntimeException {

	private static final long serialVersionUID = 504708569538541032L;

	public InputErrorException(String message) {
		super(message);
	}

}
