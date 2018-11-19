package com.ram.api.user.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lastName;
	private String firstName;
	private Adress adress;

}
