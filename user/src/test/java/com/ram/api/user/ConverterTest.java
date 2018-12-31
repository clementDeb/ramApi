package com.ram.api.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ram.api.model.User;
import com.ram.api.model.superclass.Person;
import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.service.PersonConverter;

public class ConverterTest {
	
	@Test
	public void userToUserEntityTest() {
		Person user = new User("test", "test");
		user.setId(1);
		
		PersonEntity entity = PersonConverter.INSTANCE.toPersonEntity(user);
		
		assertEquals(entity.getFirstName(), user.getFirstName());
		assertEquals(entity.getLastName(), user.getLastName());
		assertEquals(entity.getId(), user.getId());
		
	}
	
	
}
