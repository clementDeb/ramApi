package com.ram.api.model;


import org.springframework.stereotype.Component;

import com.ram.api.model.superclass.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Component
@Data
@NoArgsConstructor
public class Adress{
	
	private String adressLineOne;
	private String adressLineTwo;
	private String adressLineThree;
	private String country;
	private String zipCode;
	private int houseNumber;
//	@NonNull
//	private Person person;
	

}
