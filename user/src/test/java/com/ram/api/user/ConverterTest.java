package com.ram.api.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ram.api.persistance.UserEntity;
import com.ram.api.service.Converter;
import com.ram.api.user.model.User;

public class ConverterTest {

	@Test
	public void userToUserEntityTest() {
		User user = new User();
		user.setFirstName("firstname");
		user.setNickName("nickName");
		
		UserEntity entity = Converter.INSTANCE.userToUserEntity(user);
		
		assertEquals(entity.getFirstName(), user.getFirstName());
		assertEquals(entity.getNickName(), user.getNickName());
		
	}
	
	
}
