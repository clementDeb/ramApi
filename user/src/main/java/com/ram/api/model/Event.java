package com.ram.api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.ram.api.model.superclass.Attachment;
import com.ram.api.model.superclass.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
public class Event extends Attachment{
	
	private Adress adress;
	private LocalDateTime eventDate;
	@ToString.Exclude
	private List<Person> listContact;


}
