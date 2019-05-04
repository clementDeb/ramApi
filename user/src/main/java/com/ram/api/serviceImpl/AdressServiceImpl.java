package com.ram.api.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.service.AdressService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@CacheConfig(cacheManager="adressCacheManager")
public class AdressServiceImpl implements AdressService{
	
	private static final String ADRESS_NOT_FOUND_MSG = "adress not found";
	
	@Autowired
	AdressRepository adressRepository;

	@Override
	@Cacheable
	public AdressEntity createAdress(AdressEntity adress) {
		adress = adressRepository.save(adress);
		return adress;
	}

	@Override
	@Cacheable(value="adress")
	public AdressEntity retrieveAdress(long adressId) throws AdressNotFoundException {
		Optional<AdressEntity> adressOptional = adressRepository.findById(adressId);
		return adressOptional.orElseThrow(() -> new AdressNotFoundException(ADRESS_NOT_FOUND_MSG));
	}

	@Override
	@CachePut(value="adress")
	public AdressEntity updateAdress(AdressEntity adress) {
		log.debug("in updateAdress");
		return adressRepository.save(adress);
	}

	@Override
	@CacheEvict(value="adress")
	public void deleteAdress(AdressEntity entity) {
		adressRepository.delete(entity);
	}

}
