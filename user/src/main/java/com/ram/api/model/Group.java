package com.ram.api.model;

import java.util.List;

import com.ram.api.model.superclass.Attachment;
import com.ram.api.model.superclass.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
public class Group extends Attachment{
	
	@ToString.Exclude
	private List<Person> contactList;
	private User user;

}
