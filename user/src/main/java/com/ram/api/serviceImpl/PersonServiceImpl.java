package com.ram.api.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.ram.api.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public LocalDateTime retrieveCreationDate() {
		return LocalDateTime.now();
	}


}
