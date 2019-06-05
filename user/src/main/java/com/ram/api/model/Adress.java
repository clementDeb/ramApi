package com.ram.api.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	private long id;
	private String adressLineOne;
	private String adressLineTwo;
	private String adressLineThree;
	private String country;
	private String zipCode;
	private Integer houseNumber;
	@NotNull
	private Integer personId;
	

}
