package com.ram.api.test.service;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.api.RamApi;
import com.ram.api.exceptions.AdressExistException;
import com.ram.api.model.Adress;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.service.AdressService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RamApi.class)
public class AdressServiceTest {
	
	@MockBean(AdressRepository.class)
	private AdressRepository repository;
	
	@Autowired
	private AdressService service;
	
	@Test(expected=AdressExistException.class)
	public void createAdressWithExceptionTest() throws AdressExistException {
		AdressEntity input = retrieveAdress();
		AdressEntity expected  = retrieveAdress();
		List<AdressEntity> adresses = Arrays.asList(input, expected);
		
		Mockito.when(repository.findAllByPersonId(Mockito.anyLong())).thenReturn(adresses);
		
		service.createAdress(input);
		
		Mockito.verify(repository.save(input),Mockito.never());
				
	}
	
	private AdressEntity retrieveAdress() {
		AdressEntity adress = new AdressEntity();
		adress.setAdressLineOne("lineOne");
		adress.setCountry("france");
		adress.setHouseNumber(44);
		adress.setZipCode("33200");
		adress.setPersonId(1);
		return adress;
	}

}
