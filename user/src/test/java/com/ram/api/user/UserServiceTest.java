package com.ram.api.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Optional;

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
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.UserRepository;
import com.ram.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RamApi.class)
public class UserServiceTest {
	
	@MockBean(UserRepository.class)
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	
	@Test
	public void retrieveUserTest (){
		
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
	
	@Test(expected=UserNotFoundException.class)
	public void retrieveUserWithExceptionTest () throws UserNotFoundException{	
		String login = "false";			
		Mockito.when(this.userRepository.findUserByLogin(login)).thenReturn(Optional.empty());
		
		this.userService.retrieveUser(login);
		
	}
}
