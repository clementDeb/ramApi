package com.ram.api.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ram.api.RamApi;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.service.AdressService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RamApi.class)
public class AdressServiceTest {
	
	@MockBean(AdressRepository.class)
	private AdressRepository repository;
	
	@Autowired
	private AdressService service;

}
