package com.ram.api.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.api.persistance.AdressEntity;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.service.AdressService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AdressServiceImpl implements AdressService{
	
	@Autowired
	AdressRepository adressRepository;

	@Override
	public AdressEntity createAdress(AdressEntity adress) {
		adress = adressRepository.save(adress);
		return adress;
	}

	@Override
	public AdressEntity retrieveAdress(int adressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdressEntity updateAdress(AdressEntity adress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdress(int adressId) {
		// TODO Auto-generated method stub
		
	}

}
