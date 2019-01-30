package com.ram.api.persistance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate(true)
@Table(name="contact")
@DiscriminatorValue(value="contact")
public class ContactEntity extends PersonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
