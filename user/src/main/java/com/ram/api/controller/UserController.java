package com.ram.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ram.api.converter.PersonConverter;
import com.ram.api.exception.UserException;
import com.ram.api.model.User;
import com.ram.api.persistance.UserEntity;
import com.ram.api.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PersonConverter converter;
	
	@ResponseBody
    @RequestMapping(value="/users", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User createUser(@RequestBody User user) { 
		log.debug("in createUser with user: " + user.toString());  	
    	UserEntity entity = (UserEntity) converter.toPersonEntity(user);
    	entity = userService.createAccount(entity);
    	User userDB = (User) converter.toPerson(entity);
    	log.debug("in createUser with returned user: " + userDB.toString());
        return userDB;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User retrieveUser (@RequestParam String login) {
    	log.debug("in retrieveUser with login: " + login);
    	UserEntity entity = new UserEntity();
		try {
			entity = userService.retrieveUser(login);
		} catch (UserException e) {
			String error = e.getMsg();
			log.error("in retrieve User: " + error);
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, error);		
		}
    	User user = (User) converter.toPerson(entity);
    	log.debug("in retrieveUser with retruned user: " + user);
    	return user;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User updateUser (@RequestBody User user) {
    	log.debug("in updateUser");
    	UserEntity entity = (UserEntity) converter.toPersonEntity(user);
    	entity = userService.updateUser(entity);
    	User userDB = (User) converter.toPerson(entity);
    	return userDB;
    }
    
    @RequestMapping(value="/users", method=RequestMethod.DELETE)
    public void deleteUser (@RequestParam String login) {
    	log.debug("in deleteUser with login: " + login);
    	UserEntity entity = new UserEntity();
		try {
			entity = userService.retrieveUser(login);
		} catch (UserException e) {
			String error = e.getMsg();
			log.error("in delete User: " + error);
			throw new ResponseStatusException(
					HttpStatus.CONFLICT, error);
		}
    	userService.deleteUser(entity);
    }
    	
}
