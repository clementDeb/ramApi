package com.ram.api.model;

import java.time.LocalDateTime;

import com.ram.api.model.superclass.Attachment;
import com.ram.api.model.superclass.Person;

import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(callSuper=true)
public class Comment extends Attachment {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Person person;
	private String comment;
	private LocalDateTime creationDate;
	

}
