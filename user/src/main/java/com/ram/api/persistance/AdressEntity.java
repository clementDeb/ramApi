package com.ram.api.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.ram.api.model.User;
import com.ram.api.model.superclass.Person;

import lombok.Data;

@Data
@Entity
@DynamicUpdate(true)
@Table
public class AdressEntity {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="adressLineOne")
	private String adressLineOne;
	@Column(name="adressLineTwo")
	private String adressLineTwo;
	@Column(name="adressLineThree")
	private String adressLineThree;
	@Column(name="country")
	private String country;
	@Column(name="zipCode")
	private String zipCode;
	@Column(name="houseNumber")
	private int houseNumber;
	@Column (name="user")
	@ManyToOne
	private PersonEntity person;
	

}
