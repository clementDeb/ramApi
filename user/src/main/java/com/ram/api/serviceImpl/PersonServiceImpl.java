package com.ram.api.serviceImpl;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.ram.api.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public Instant retrieveCreationDate() {
		return Instant.now();
	}


}
