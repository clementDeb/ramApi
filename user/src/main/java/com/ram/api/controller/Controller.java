package com.ram.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.model.User;
import com.ram.api.model.superclass.Person;
import com.ram.api.persistance.UserEntity;
import com.ram.api.service.Converter;
import com.ram.api.service.UserService;

@RestController
@ComponentScan("com.ram.api.user")
public class Controller {
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	Converter converter;
	
	@ResponseBody
    @RequestMapping(value="/users", method=RequestMethod.POST)
    public Person createUser(@RequestBody User user) {    	
    	UserEntity entity = (UserEntity) Converter.INSTANCE.dtoToEntity(user);   
    	entity = userService.createAccount(entity);
    	user = (User) Converter.INSTANCE.entityToDto(entity);

        return user;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public User retrieveUser (@RequestParam String login) {
    	return null;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.PUT)
    public User updateUser (@RequestParam String login) {
    	return null;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.DELETE)
    public void deleteUser (@RequestParam String login) {
    }

}
