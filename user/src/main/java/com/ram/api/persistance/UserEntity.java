package com.ram.api.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="NICKNAME")
	private String nickName;
	@Column(name="LOGIN")
	private String login;
	@Column(name="PASSWORD")
	private String password;	
	
}

