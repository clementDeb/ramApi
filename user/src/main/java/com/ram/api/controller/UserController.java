package com.ram.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ram.api.converter.AdressConverter;
import com.ram.api.converter.PersonConverter;
import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.exceptions.EmailExistException;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.model.Adress;
import com.ram.api.model.User;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor=@__({@Autowired}))
@RequestMapping(value="/users")
public class UserController {

	private final UserService userService;

	private final PersonConverter converter;

	private final AdressConverter adressConverter;
	
	//@CrossOrigin(origins="http://127.0.0.1:3000")
	@ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) { 
		log.debug("in createUser with user: " + user.toString());  	
    	UserEntity entity = (UserEntity) converter.toPersonEntity(user);
    	try {
			entity = userService.createAccount(entity);
		} catch (EmailExistException e) {
			String error = e.getMsg();
			log.error("in retrieve createUser: " + error);
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, error);
		}
        return (User) converter.toPerson(entity);
    }
    
    @GetMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User retrieveUser (@RequestParam String login) {
    	log.debug("in retrieveUser with login: " + login);
    	UserEntity entity = new UserEntity();
		try {
			entity = userService.retrieveUser(login);
		} catch (UserNotFoundException e) {
			String error = e.getMsg();
			log.error("in retrieve User: " + error);
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, error);		
		}
    	return (User) converter.toPerson(entity);
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User updateUser (@RequestBody User user) {
    	log.debug("in updateUser");
    	UserEntity entity = (UserEntity) converter.toPersonEntity(user);
    	entity = userService.updateUser(entity);
    	return (User) converter.toPerson(entity);
    }
    
    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteUser (@RequestParam String login) {
    	log.debug("in deleteUser with login: " + login);
    	UserEntity entity = new UserEntity();
		try {
			entity = userService.retrieveUser(login);
		} catch (UserNotFoundException e) {
			String error = e.getMsg();
			log.error("in delete User: " + error);
			throw new ResponseStatusException(
					HttpStatus.CONFLICT, error);
		}
    	userService.deleteUser(entity);
    }
    
    @RequestMapping(value="/{userId}/adresses", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Adress> retrieveAdressesByUserId (@PathVariable("userId") long id) {
		List<AdressEntity> entityAdresses;
		try {
			entityAdresses = userService.retrieveAdressesByUserId(id);
		} catch (AdressNotFoundException e) {
			String error = e.getMsg();
			log.error("in retrieve retrieveAdressesByUserId: " + error);
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, error);
		}
		List<Adress> adresses = adressConverter.listEntityToDto(entityAdresses);
    	return adresses;
    }
    	
}
