package com.ram.api.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode()
public class ContactMeaning implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * contact type (phone, mail ...)
	 */
	private ContactMeaningTypeEnum type;
	/**
	 * user coordinate, could be phone number, mail adress
	 */
	private String coordinate;
	
	/**
	 * name of the contact meaning (phoneHouse, mail office ...)
	 * Whatever the user want to name this contact meaning
	 */
	private String contactName;
	
	/**
	 * user of this contactMeaning
	 */
	private User user;
	
	private Contact contact;
	
	/**
	 * Enum to define the contactm meaning type (phone, mail)
	 * @author cdebrosse
	 *
	 */
	public enum ContactMeaningTypeEnum {
		
		PHONE,
		MAIL;
		
	}
}
