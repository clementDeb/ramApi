package com.ram.api.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ram.api.converter.AdressConverter;
import com.ram.api.converter.PersonConverter;
import com.ram.api.model.Adress;
import com.ram.api.model.User;
import com.ram.api.model.superclass.Person;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;

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
	
	@Test
	public void AdressToAdressEntityTest() {
		//First create the attached User
		Person user = new User("test", "test");
		user.setId(1);
		//create and fill the adress
		Adress adress = new Adress();
		adress.setAdressLineOne("firstLineAdress");
		adress.setAdressLineTwo("secondLineAdress");
		adress.setCountry("France");
		adress.setHouseNumber(44);
		adress.setZipCode("33200");
		adress.setPerson(user);
		
		AdressEntity entity = AdressConverter.INSTANCE.dtoToEntity(adress);
		
		//assertion
		assertEquals(entity.getAdressLineOne(), adress.getAdressLineOne());
		assertEquals(entity.getAdressLineTwo(), adress.getAdressLineTwo());
		assertEquals(entity.getZipCode(), adress.getZipCode());
		assertEquals(entity.getCountry(), adress.getCountry());
		assertEquals(entity.getHouseNumber(), 44);
		assertEquals(entity.getPerson().getId(), 1);
		assertNotEquals(((UserEntity) entity.getPerson()).getLogin(), "login");
	}
	
	
}
