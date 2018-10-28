package com.ram.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.api.persistance.UserEntity;
import com.ram.api.persistance.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repository;

	@Override
	public UserEntity createAccount(UserEntity user) {
		UserEntity userSaved = new UserEntity();
		userSaved = repository.save(user);
		return userSaved;
	}

}
