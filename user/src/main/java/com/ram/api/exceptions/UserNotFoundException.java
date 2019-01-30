package com.ram.api.exceptions;

import com.ram.api.exception.UserException;

@SuppressWarnings("serial")
public class UserNotFoundException extends UserException{

	public UserNotFoundException(String msg) {
		super(msg);
	}


}
