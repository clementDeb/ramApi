package com.ram.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.converter.AdressConverter;
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
	
		
	@ResponseBody
    @RequestMapping(value="/adresses", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Adress createAdress(@RequestBody Adress adress) { 
		log.debug("in createAdress with adress: " + adress.toString()); 		
		AdressEntity adressEntity = adressConverter.dtoToEntity(adress);
		adressEntity = adressService.createAdress(adressEntity);
		
		adress = adressConverter.entityToDto(adressEntity);
        return adress;
    }
    
    @RequestMapping(value="/adresses", method=RequestMethod.GET)
    public Adress retrieveAdress (@RequestParam int adressId) {
    	log.debug("in retrieveUser with adressId: " + adressId);
    	
    	return null;
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
