package com.ram.api.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ram.api.persistance.UserEntity;
import com.ram.api.user.model.User;

@Mapper(componentModel="spring")
public interface Converter {
	
	Converter INSTANCE = Mappers.getMapper( Converter.class );
	
	/**Method to convert an entity into a dto
	 * @param user
	 * @return the converted entity into dto
	 */
	User userEntityToUser(UserEntity user);
	
	/**Method to convert a dto into an entity
	 * @param user
	 * @returnthe converted dto into entity
	 */
	UserEntity userToUserEntity(User user);

}
