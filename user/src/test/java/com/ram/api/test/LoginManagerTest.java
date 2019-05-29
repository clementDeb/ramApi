package com.ram.api.test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.api.RamApi;
import com.ram.api.serviceImpl.LoginManager;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes=RamApi.class)
@RunWith(SpringRunner.class)
public class LoginManagerTest {
	
	@Autowired
	LoginManager loginManager;
	
	@Test
	public void loginExistTest() {
		
		List<String> logins = Collections.singletonList("login");	
		String input = "login";	
		boolean expected = true;
		
		assertEquals(expected, loginManager.loginExist(input, logins));
		
	}

}
