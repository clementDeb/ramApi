package com.ram.api.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.api.RamApi;
import com.ram.api.converter.AdressConverter;
import com.ram.api.converter.PersonConverter;
import com.ram.api.model.Adress;
import com.ram.api.model.User;
import com.ram.api.model.superclass.Person;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.PersonEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RamApi.class)
public class ConverterTest {
	
	@Autowired
	PersonConverter personeConverter; 
	@Autowired
	AdressConverter adressConverter;
	
	@Test
	public void userToUserEntityTest() {				
		Person user = new User("test", "test");
		user.setId(1);
		
		PersonEntity entity = personeConverter.toPersonEntity(user);
		
		assertEquals(entity.getFirstName(), user.getFirstName());
		assertEquals(entity.getLastName(), user.getLastName());
		assertEquals(entity.getId(), user.getId());

	}
	
	@Test
	public void AdressToAdressEntityTest() {
		//create and fill the adress
		Adress adress = new Adress();
		adress.setAdressLineOne("firstLineAdress");
		adress.setAdressLineTwo("secondLineAdress");
		adress.setCountry("France");
		adress.setHouseNumber(44);
		adress.setZipCode("33200");
	
		AdressEntity entity = adressConverter.dtoToEntity(adress);
		
		//assertion
		assertEquals(entity.getAdressLineOne(), adress.getAdressLineOne());
		assertEquals(entity.getAdressLineTwo(), adress.getAdressLineTwo());
		assertEquals(entity.getZipCode(), adress.getZipCode());
		assertEquals(entity.getCountry(), adress.getCountry());
		assertEquals(entity.getHouseNumber(), 44);
	}
	
	
}
