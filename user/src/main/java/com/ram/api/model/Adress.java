package com.ram.api.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Adress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String adressLineOne;
	private String adressLineTwo;
	private String adressLineThree;
	private String country;
	private String zipCode;
	private int houseNumber;
	

}
