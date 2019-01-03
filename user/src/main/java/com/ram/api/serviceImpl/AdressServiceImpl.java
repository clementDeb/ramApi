package com.ram.api.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ram.api.persistance.AdressEntity;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.service.AdressService;

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
