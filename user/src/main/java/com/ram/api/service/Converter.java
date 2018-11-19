package com.ram.api.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ram.api.model.superclass.Person;
import com.ram.api.persistance.PersonEntity;

@Mapper
public interface Converter {
	
	//Not used if CDI is done with Spring
	Converter INSTANCE = Mappers.getMapper(Converter.class);
	
	/**Method to convert an entity into a dto
	 * @param user
	 * @return the converted entity into dto
	 */
	Person entityToDto(PersonEntity entity);
	
	/**Method to convert a dto into an entity
	 * @param user
	 * @returnthe converted dto into entity
	 */
	PersonEntity dtoToEntity(Person dto);

}
