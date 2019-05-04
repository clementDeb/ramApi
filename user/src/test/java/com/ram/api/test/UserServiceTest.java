package com.ram.api.test;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.api.RamApi;
import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.UserRepository;
import com.ram.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RamApi.class)
public class UserServiceTest {

	@MockBean(UserRepository.class)
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	@Autowired
	CacheManager manager;

	@Test
	public void retrieveUserTest() {

		String login = "Login";

		UserEntity entityOne = new UserEntity();
		entityOne.setFirstName("firstNameOne");
		entityOne.setLastName("lastNameOne");
		entityOne.setId(1);
		
		UserEntity entityTwo = new UserEntity();
		entityTwo.setFirstName("firstNameTwo");
		entityTwo.setLastName("lastNameTwo");
		entityTwo.setId(3);

		Mockito.when(this.userRepository.findUserByLogin(login)).thenReturn(Optional.of(entityOne), Optional.of(entityTwo));

		try {
			//firstcall
			assertEquals(entityOne, this.userService.retrieveUser(login));
			//second call
			assertEquals(entityOne, this.userService.retrieveUser(login));
		} catch (UserNotFoundException e) {
			Mockito.doNothing();
		}

	}

	@Test(expected = UserNotFoundException.class)
	public void retrieveUserWithExceptionTest() throws UserNotFoundException {
		String login = "false";
		Mockito.when(this.userRepository.findUserByLogin(login)).thenReturn(Optional.empty());

		this.userService.retrieveUser(login);

	}

	@Test
	public void updateUserTest() {
		String loginModified = "Login";

		UserEntity entity = new UserEntity();
		entity.setFirstName("firstName");
		entity.setLastName("lastName");
		entity.setId(3);
		entity.setLogin("Login");

		Mockito.when(this.userRepository.save(entity)).thenReturn(entity);

		assertEquals(loginModified, this.userService.updateUser(entity).getLogin());
	}
	
	@Test
	public void retrieveAdressesByUserIdTest() {
		List<AdressEntity> listAdress = new ArrayList<AdressEntity>();
		UserEntity entity = new UserEntity();
		AdressEntity adrOne = new AdressEntity();
		AdressEntity adrTwo = new AdressEntity();
		
		//create Adress
		adrOne.setAdressLineOne("firstLine");
		adrOne.setCountry("Norvege");
		adrOne.setZipCode("33200");
		adrOne.setCreationDate(Instant.now().plusSeconds(30));
		
		adrTwo.setAdressLineOne("firstLine");
		adrTwo.setCountry("France");
		adrTwo.setZipCode("33520");
		adrTwo.setCreationDate(Instant.now());
		
		listAdress.add(adrOne);
		listAdress.add(adrTwo);
		
		entity.setAdresses(listAdress);
		
		try {
			assertEquals("France", this.userService.retrieveAdressesByUserId(entity).get(0).getCountry());
		} catch (AdressNotFoundException e) {
			Mockito.doNothing();
		}

	}
	
	@Test(expected = AdressNotFoundException.class)
	public void retrieveAdressesByUserIdTestEmptyList() throws AdressNotFoundException {
		UserEntity entity = new UserEntity();		
		this.userService.retrieveAdressesByUserId(entity);
	}
}
