package com.ram.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.service.AdressService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AdressServiceImpl implements AdressService{
	
	private static final String ADRESS_NOT_FOUND_MSG = "adress not found";
	
	@Autowired
	AdressRepository adressRepository;

	@Override
	public AdressEntity createAdress(AdressEntity adress) {
		adress = adressRepository.save(adress);
		return adress;
	}

	@Override
	public AdressEntity retrieveAdress(long adressId) throws AdressNotFoundException {
		Optional<AdressEntity> adressOptional = adressRepository.findById(adressId);
		return adressOptional.orElseThrow(() -> new AdressNotFoundException(ADRESS_NOT_FOUND_MSG));
	}

	@Override
	public AdressEntity updateAdress(AdressEntity adress) {
		log.debug("in updateAdress");
		return adressRepository.save(adress);
	}

	@Override
	public void deleteAdress(AdressEntity entity) {
		adressRepository.delete(entity);
	}

}
