package com.ram.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

}
