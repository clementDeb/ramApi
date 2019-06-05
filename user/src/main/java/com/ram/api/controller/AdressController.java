package com.ram.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.ram.api.exceptions.AdressExistException;
import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.model.Adress;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.service.AdressService;
import com.ram.api.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor=@__({@Autowired}))
@RequestMapping(value="/adresses")
public class AdressController {
	
	private final AdressService adressService;

	private final AdressConverter adressConverter;

	private final UserService userService;
	
		
	@ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Adress createAdress(@RequestBody Adress adress, @RequestParam String userId) { 
		log.debug("in createAdress with adress: " + adress.toString()); 
		UserEntity userEntity = null;
		try {
			userEntity = userService.findUserById(Integer.parseInt(userId));
		} catch (UserNotFoundException e) {
			String error = e.getMsg();
			log.error("in retrieve Adress: " + error);
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, error);
		}
		
		AdressEntity adressEntity = adressConverter.dtoToEntity(adress);
		try {
			adressEntity = adressService.createAdress(adressEntity);
		} catch (AdressExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AdressEntity> adresses = new ArrayList<>();
		adresses.add(adressEntity);
		//update the user
		userEntity.setAdresses(adresses);
		userService.updateUser(userEntity);
		adress = adressConverter.entityToDto(adressEntity);
        return adress;
    }
    
    @GetMapping(value="/{adressId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Adress retrieveAdress (@PathVariable int adressId) {
    	log.debug("in retrieveAdress with adressId: " + adressId);
    	AdressEntity entity;
		try {
			entity = adressService.retrieveAdress(adressId);
		} catch (AdressNotFoundException e) {
			String error = e.getMsg();
			log.error("in retrieve Adress: " + error);
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, error);
		}
    	Adress adress = adressConverter.entityToDto(entity);   	
    	return adress;
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Adress updateAdress (@RequestBody Adress adress) {
    	log.debug("in updateUser");
    	AdressEntity entity = adressConverter.dtoToEntity(adress);
    	entity = adressService.updateAdress(entity);
    	return adressConverter.entityToDto(entity);
    }
    
    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteAdress (@RequestParam int adressId) {
    	log.debug("in deleteAdress with login: " + adressId);
    	AdressEntity entity = new AdressEntity();
		try {
			entity = adressService.retrieveAdress(adressId);
		} catch (AdressNotFoundException e) {
			String error = e.getMsg();
			log.error("in delete adress: " + error);
			throw new ResponseStatusException(
					HttpStatus.CONFLICT, error);
		}
    	adressService.deleteAdress(entity);
    }

}
