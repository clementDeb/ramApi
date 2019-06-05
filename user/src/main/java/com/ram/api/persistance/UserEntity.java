package com.ram.api.persistance;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@DynamicUpdate(true)
@Table(name="user")
public class UserEntity extends PersonEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Column(name="LOGIN")
	private String login;
	@NotNull
	@Column(name="PASSWORD")
	private String password;
	
	
}

