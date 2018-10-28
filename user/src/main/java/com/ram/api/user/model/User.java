package com.ram.api.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class User extends Person{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;
	private String login;
	private String password;

	
	
	
	

}
