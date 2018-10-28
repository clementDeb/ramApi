package com.ram.api.persistance;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import lombok.Data;

@Data
@Table(appliesTo = "person")
@DynamicUpdate(true)
public class PersonEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="FIRSTNAME")
	private String firstName;
	@OneToMany
	List<AdressEntity> adresses;

}
