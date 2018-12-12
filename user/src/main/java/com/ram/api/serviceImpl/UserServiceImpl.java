package com.ram.api.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.api.exception.UserException;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.superclass.PersonRepository;
import com.ram.api.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{
	
	//private final Logger log = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	PersonRepository<UserEntity> userRepository;

	@Override
	@Transactional
	public UserEntity createAccount(UserEntity user) {
		log.debug("in userServiceImpl");
		UserEntity userSaved = new UserEntity();
		try {
			userSaved = userRepository.save(user);
		} catch (Exception e) {
			log.error("ERROR while saving the user");
		}
		return userSaved;
	}

}
