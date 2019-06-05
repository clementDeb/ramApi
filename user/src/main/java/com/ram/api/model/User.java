package com.ram.api.model;

import javax.validation.constraints.NotNull;

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

	@NotNull
	@EqualsAndHashCode.Include
	private String login;
	@NotNull
	@EqualsAndHashCode.Include
	private String password;	

}
