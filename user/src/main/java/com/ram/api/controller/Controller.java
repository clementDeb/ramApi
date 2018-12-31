package com.ram.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.model.User;
import com.ram.api.persistance.UserEntity;
import com.ram.api.service.PersonConverter;
import com.ram.api.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@ComponentScan("com.ram.api.user")
@Log4j2
public class Controller {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PersonConverter converter;
	
	@ResponseBody
    @RequestMapping(value="/users", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User createUser(@RequestBody User user) { 
		log.debug("in createUser with user: " + user.toString());  	
    	var entity = (UserEntity) converter.toPersonEntity(user);
    	entity = userService.createAccount(entity);
    	var userDB = (User) converter.toPerson(entity);
    	log.debug("in createUser with returned user: " + userDB.toString());
        return userDB;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.GET)
    public User retrieveUser (@RequestParam String login) {
    	log.debug("in retrieveUser with login: " + login);
    	var entity = userService.retrieveUser(login);
    	var user = (User) converter.toPerson(entity);
    	log.debug("in retrieveUser with retruned user: " + user);
    	return user;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User updateUser (@RequestBody User user) {
    	log.debug("in updateUser");
    	var entity = (UserEntity) converter.toPersonEntity(user);
    	entity = userService.updateUser(entity);
    	var userDB = (User) converter.toPerson(entity);
    	return userDB;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.DELETE)
    public void deleteUser (@RequestParam String login) {
    	log.debug("in deleteUser with login: " + login);
    	var entity = userService.retrieveUser(login);
    	userService.deleteUser(entity);
    }
}
