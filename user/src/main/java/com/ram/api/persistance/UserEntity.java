package com.ram.api.persistance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="NICKNAME")
	private String nickName;
	@Column(name="LOGIN")
	private String login;
	@Column(name="PASSWORD")
	private String password;	
	
}

