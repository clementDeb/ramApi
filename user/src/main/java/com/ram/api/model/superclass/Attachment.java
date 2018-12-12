package com.ram.api.model.superclass;


import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class Attachment{
	
	@EqualsAndHashCode.Include
	@Setter(AccessLevel.NONE)
	public int id;
	@EqualsAndHashCode.Include
	public AttachmentType type;
	public String name;
	
	/**
	 * enum to know the type of Attachment
	 * @author cdebrosse
	 *
	 */
	public enum AttachmentType {
		
		GROUP,
		NOTE_CARD,
		POINT_OF_INTEREST,
		EVENTS;
		
	}

}
