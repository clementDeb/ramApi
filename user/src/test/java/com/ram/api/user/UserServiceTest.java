package com.ram.api.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.api.RamApi;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.model.Adress;
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

	@Test
	public void retrieveUserTest() {

		String login = "Login";

		UserEntity entity = new UserEntity();
		entity.setFirstName("firstName");
		entity.setLastName("lastName");
		entity.setId(3);

		Mockito.when(this.userRepository.findUserByLogin(login)).thenReturn(Optional.of(entity));

		try {
			assertEquals("firstName", this.userService.retrieveUser(login).getFirstName());
			assertEquals("lastName", this.userService.retrieveUser(login).getLastName());
			assertEquals(3, this.userService.retrieveUser(login).getId());
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
		
		assertEquals("France", this.userService.retrieveAdressesByUserId(entity).get(0).getCountry());

	}
	
	@Test
	public void retrieveAdressesByUserIdTestEmptyList() {
		UserEntity entityOne = new UserEntity();
		UserEntity entityTwo = new UserEntity();
		List<AdressEntity> listAdress = new ArrayList<AdressEntity>();
		entityOne.setAdresses(null);
		entityTwo.setAdresses(listAdress);
		
		assertTrue(this.userService.retrieveAdressesByUserId(entityOne).isEmpty());
		assertTrue(this.userService.retrieveAdressesByUserId(entityTwo).isEmpty());
	}
}
