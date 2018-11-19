package com.ram.api.persistance;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Table
@Entity
@DynamicUpdate(true)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class PersonEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="lastName")
	private String lastName;
	@Column(name="firstName")
	private String firstName;
	@Column(name="credationDate")
	private LocalDateTime creationDate;
//	@OneToMany
//	List<AdressEntity> adresses;

}
