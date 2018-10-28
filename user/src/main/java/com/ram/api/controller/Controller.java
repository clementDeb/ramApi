package com.ram.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.persistance.UserEntity;
import com.ram.api.service.Converter;
import com.ram.api.service.UserService;
import com.ram.api.user.model.User;

@RestController
@ComponentScan("com.ram.api.user")
public class Controller {
	
	@Autowired
	UserService userService;
	
	@Autowired
	Converter converter;
	
    @RequestMapping(value="/users", method=RequestMethod.POST)
    public User createAccount(@RequestParam String login,
    		@RequestParam String password,
    		@RequestParam String nickName) {
    	User user = new User();
    	user.setLogin(login);
    	user.setPassword(password);
    	user.setNickName(nickName);
    	
    	UserEntity entity = converter.userToUserEntity(user);   
    	entity = userService.createAccount(entity);
    	
    	user = converter.userEntityToUser(entity);

        return user;
    }

}
