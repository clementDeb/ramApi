package com.ram.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ram.api.model.Adress;
import com.ram.api.persistance.AdressEntity;

@Mapper(uses=PersonConverter.class)
public interface AdressConverter {
	
	//PersonConverter PersonConverterInstance = Mappers.getMapper(PersonConverter.class);
	
	AdressConverter INSTANCE = Mappers.getMapper(AdressConverter.class);
	
	/**Method to convert an entity into a dto
	 * @param user
	 * @return the converted entity into dto
	 */
	Adress entityToDto(AdressEntity entity);
	
	/**Method to convert a dto into an entity
	 * @param user
	 * @returnthe converted dto into entity
	 */
	AdressEntity dtoToEntity(Adress dto);

}
