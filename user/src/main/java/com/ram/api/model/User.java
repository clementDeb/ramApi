package com.ram.api.model;

import org.springframework.stereotype.Component;

import com.ram.api.model.superclass.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person{


	@EqualsAndHashCode.Include
	private String login;
	@EqualsAndHashCode.Include
	private String password;	

}
