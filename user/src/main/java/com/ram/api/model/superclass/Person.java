package com.ram.api.model.superclass;

import java.util.List;

import com.ram.api.model.Adress;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Person{

	@EqualsAndHashCode.Include
	private int id;
	@EqualsAndHashCode.Include
	private GenderEnum gender;
	private String lastName;
	private String firstName;
	private Adress adress;	
	@ToString.Exclude
	private List<Attachment> AttachmentList;

	public enum GenderEnum {

		MR("Male", "Mr"), MS("Female", "Mme");

		private final String gender;
		private final String civility;

		GenderEnum(String gender, String civility) {
			this.gender = gender;
			this.civility = civility;
		}

		/**
		 * Method to retrieve the wanted enum using an id
		 * 
		 * @param id
		 * @return
		 */
		public GenderEnum retrieveGenderEnum(int id) {
			GenderEnum returnedEnum = null;
			for (GenderEnum e : GenderEnum.values()) {
				if (e.ordinal() == id) {
					returnedEnum = e;
					break;
				}
			}
			return returnedEnum;
		}
	}

}
