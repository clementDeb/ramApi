package com.ram.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ram.api.model.Contact;
import com.ram.api.model.User;
import com.ram.api.model.superclass.Person;
import com.ram.api.persistance.ContactEntity;
import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;

@Mapper(componentModel="spring", uses=AdressConverter.class)
public interface PersonConverter {
	
	default PersonEntity toPersonEntity(Person person) {
		if (person instanceof User) {
			return dtoToEntity((User)person);
		}else if (person instanceof Contact) {
			return dtoToEntity((Contact) person);
		}
		return null;
	}
	
	default Person toPerson(PersonEntity entity) {
		if (entity instanceof UserEntity) {
			return entityToDto((UserEntity)entity);
		}else if (entity instanceof ContactEntity) {
			return entityToDto((ContactEntity) entity);
		}
		return null;
	}
	
	/**Method to convert an entity into a dto
	 * @param user
	 * @return the converted entity into dto
	 */
	User entityToDto(UserEntity entity);
	
	/**Method to convert a dto into an entity
	 * @param user
	 * @returnthe converted dto into entity
	 */
	UserEntity dtoToEntity(User dto);
	
	/**Method to convert an entity into a dto
	 * @param user
	 * @return the converted entity into dto
	 */
	Contact entityToDto(ContactEntity entity);
	
	/**Method to convert a dto into an entity
	 * @param user
	 * @returnthe converted dto into entity
	 */
	ContactEntity dtoToEntity(Contact dto);

}
