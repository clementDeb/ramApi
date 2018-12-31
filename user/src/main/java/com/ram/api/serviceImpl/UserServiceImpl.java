package com.ram.api.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.api.exception.UserException;
import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.superclass.PersonRepository;
import com.ram.api.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{
	
	@Autowired
	PersonRepository<UserEntity> userRepository;

	@Override
	@Transactional
	public UserEntity createAccount(UserEntity entity) {
		log.debug("in createAccount");
		UserEntity userSaved = new UserEntity();
		try {
			userSaved = userRepository.save(entity);
		} catch (Exception e) {
			log.error("ERROR while saving the user");
		}
		return userSaved;
	}

	@Override
	@Transactional
	public UserEntity retrieveUser(String login) {
		log.debug("in retrieveUser");
		UserEntity userRetrieved = new UserEntity();
		userRetrieved = userRepository.findUserByLogin(login);
		return userRetrieved;
	}

	@Override
	@Transactional
	public UserEntity updateUser(UserEntity entity) {
		log.debug("in updateUser");
		UserEntity userSaved = new UserEntity();
		userSaved = userRepository.save(entity);
		return userSaved;
	}

	@Override
	public void deleteUser(UserEntity entity) {
		log.debug("in deleteUser");
		userRepository.delete(entity);
		
	}

}
