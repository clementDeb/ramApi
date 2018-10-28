package com.ram.api.user.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String lastName;
	private String firstName;
	private String nickName;
	private String login;
	private String password;

	
	
	
	

}
