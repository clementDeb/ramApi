package com.ram.api.persistance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.ram.api.model.superclass.Attachment.AttachmentType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DynamicUpdate(true)
@Table(name="attachment")
@Data
@EqualsAndHashCode
public abstract class AttachmentEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	public int id;
	@Column(name="attachmentType")
	public AttachmentType type;
	@Column(name="name")
	public String name;

}
