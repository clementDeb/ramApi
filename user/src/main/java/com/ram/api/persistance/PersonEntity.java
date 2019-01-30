package com.ram.api.persistance;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.ram.api.model.Adress;

import lombok.Data;

@Data
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class PersonEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	@Column(name="lastName")
	private String lastName;
	@Column(name="firstName")
	private String firstName;
	@Column(name="nickName")
	private String nickName;
	@Column(name="creationDate")
	private LocalDateTime creationDate;
	@Column(name="genderId")
	private int genderId;
	@Column(name="adress")
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private List<AdressEntity> adresses;

}
