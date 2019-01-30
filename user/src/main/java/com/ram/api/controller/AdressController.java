package com.ram.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.converter.AdressConverter;
import com.ram.api.exception.UserException;
import com.ram.api.model.Adress;
import com.ram.api.model.User;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.service.AdressService;
import com.ram.api.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class AdressController {
	
	@Autowired
	AdressService adressService;
	
	@Autowired
	AdressConverter adressConverter;
	
	@Autowired
	UserService userService;
	
		
	@ResponseBody
    @RequestMapping(value="/adresses", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Adress createAdress(@RequestBody Adress adress, @RequestParam String userId) { 
		log.debug("in createAdress with adress: " + adress.toString()); 
		UserEntity userEntity = null;
		try {
			userEntity = userService.findUserById(Integer.parseInt(userId));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AdressEntity adressEntity = adressConverter.dtoToEntity(adress);
		adressEntity = adressService.createAdress(adressEntity);
		List<AdressEntity> adresses = new ArrayList<>();
		adresses.add(adressEntity);
		//update the user
		userEntity.setAdresses(adresses);
		userService.updateUser(userEntity);
		//convert the adress to DTO
		adress = adressConverter.entityToDto(adressEntity);
        return adress;
    }
    
    @RequestMapping(value="/adresses", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Adress retrieveAdress (@RequestParam long adressId) {
    	log.debug("in retrieveUser with adressId: " + adressId);
    	AdressEntity entity = adressService.retrieveAdress(adressId);
    	Adress adress = adressConverter.entityToDto(entity);   	
    	return adress;
    }
    
    @RequestMapping(value="/adresses", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Adress updateAdress (@RequestBody Adress adress) {
    	log.debug("in updateUser");
    	
    	return null;
    }
    
    @RequestMapping(value="/adresses", method=RequestMethod.DELETE)
    public void deleteAdress (@RequestParam int adressId) {
    	
    }

}
