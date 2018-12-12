package com.ram.api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.ram.api.model.superclass.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
public class Contact extends Person {

	@ToString.Exclude
	private List<ContactMeaning> contactMeaningList;
	private LocalDateTime addedDate;
	

}
