package com.ram.api.model;

import java.util.List;

import com.ram.api.model.superclass.Attachment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
public class PointOfInterest extends Attachment{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Adress adress;
	@ToString.Exclude
	private List<Comment> listComment;
	@ToString.Exclude
	private List<Contact> listContact;

}
