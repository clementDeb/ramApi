package com.ram.api.persistance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@DynamicUpdate(true)
@Table(appliesTo = "user")
public class UserEntity extends PersonEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="NICKNAME")
	private String nickName;
	@Column(name="LOGIN")
	private String login;
	@Column(name="PASSWORD")
	private String password;	
	
}

