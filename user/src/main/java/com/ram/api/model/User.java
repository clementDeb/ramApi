package com.ram.api.model;

import org.springframework.stereotype.Component;

import com.ram.api.model.superclass.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=true)
@RequiredArgsConstructor
public class User extends Person{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;
	@NonNull
	@EqualsAndHashCode.Include
	private String login;
	@NonNull
	@EqualsAndHashCode.Include
	private String password;
	
	
	/** Method to retrieve the current Instance of the User
	 * @return
	 */
	public static User getInstance() {
		return null;
	}
	

}
