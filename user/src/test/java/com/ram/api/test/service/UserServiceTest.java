package com.ram.api.test.service;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.api.RamApi;
import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.exceptions.EmailExistException;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.repositories.UserRepository;
import com.ram.api.service.UserService;
import com.ram.api.serviceImpl.LoginManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RamApi.class)
public class UserServiceTest {

	@MockBean(UserRepository.class)
	private UserRepository userRepository;
	
	@MockBean(AdressRepository.class)
	private AdressRepository adressRepository;
	
	@MockBean(LoginManager.class)
	private LoginManager loginManager;

	@Autowired
	private UserService userService;
	
	@Autowired
	CacheManager manager;
	
	@Test
	public void createAccountTest() {
		UserEntity entityOne = new UserEntity();
		entityOne.setFirstName("firstName");
		entityOne.setLastName("lastName");
		entityOne.setId(1);
		entityOne.setLogin("login");
		entityOne.setPassword("password");
		
		UserEntity entity = new UserEntity();
		entity.setFirstName("firstName");
		entity.setLastName("lastName");
		entity.setId(1);
		entity.setLogin("login");
		entity.setPassword("password");
		
		List<String> logins = new ArrayList<String>();
		logins.add("loginMock");
		
		Mockito.when(userRepository.findAllLogin()).thenReturn(logins);
		Mockito.when(loginManager.encode(Mockito.anyString())).thenReturn(entityOne.getPassword());
		Mockito.when(userRepository.save(entityOne)).thenReturn(entity);
		
		try {
			assertEquals(entity, userService.createAccount(entityOne));
		} catch (EmailExistException e) {
			Mockito.doNothing();
		}
	}
	
	@Test(expected=EmailExistException.class)
	public void createAccountWithExceptionTest() throws EmailExistException{
		UserEntity entity = new UserEntity();
		entity.setLogin("loginMock");
		
		List<String> logins = new ArrayList<String>();
		logins.add("loginMock");
		
		Mockito.when(userRepository.findAllLogin()).thenReturn(logins);
		Mockito.when(loginManager.loginExist(entity.getLogin(), logins)).thenReturn(true);
		
		userService.createAccount(entity);
	}

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

		Mockito.when(userRepository.findUserByLogin(login)).thenReturn(Optional.of(entityOne), Optional.of(entityTwo));

		try {
			//firstcall
			assertEquals(entityOne, userService.retrieveUser(login));
			//second call
			assertEquals(entityOne, userService.retrieveUser(login));
		} catch (UserNotFoundException e) {
			Mockito.doNothing();
		}

	}

	@Test(expected = UserNotFoundException.class)
	public void retrieveUserWithExceptionTest() throws UserNotFoundException {
		String login = "false";
		Mockito.when(userRepository.findUserByLogin(login)).thenReturn(Optional.empty());
		userService.retrieveUser(login);
	}

	@Test
	public void updateUserTest() {
		String loginModified = "Login";

		UserEntity entity = new UserEntity();
		entity.setFirstName("firstName");
		entity.setLastName("lastName");
		entity.setId(3);
		entity.setLogin("Login");

		Mockito.when(userRepository.save(entity)).thenReturn(entity);

		assertEquals(loginModified, userService.updateUser(entity).getLogin());
	}
	
	@Test
	public void retrieveAdressesByUserIdTest() {
		List<AdressEntity> listAdress = new ArrayList<AdressEntity>();
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
		
		Mockito.when(adressRepository.findAllByPersonId(1)).thenReturn(listAdress);		
		
		try {
			List<AdressEntity> expectedList = userService.retrieveAdressesByUserId(1);
			assertEquals(2, expectedList.size());
		} catch (AdressNotFoundException e) {
			Mockito.doNothing();
		}

	}
	
	@Test(expected = AdressNotFoundException.class)
	public void retrieveAdressesByUserTestEmptyList() throws AdressNotFoundException {
		Mockito.when(adressRepository.findAllByPersonId(1)).thenReturn(Collections.emptyList());		
		userService.retrieveAdressesByUserId(1);
	}
}
