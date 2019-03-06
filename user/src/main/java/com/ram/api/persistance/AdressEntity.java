package com.ram.api.persistance;


import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


import lombok.Data;

@Data
@Entity
@DynamicUpdate(true)
@Table(name="adress")
public class AdressEntity implements Comparable<AdressEntity>{
	
	@Id
	@GeneratedValue
	private long id;
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
	@Column(name="creationDate")
	private Instant creationDate;
	
	@Override
	public int compareTo(AdressEntity adr) {
		return creationDate.compareTo(adr.getCreationDate());
	}

}
