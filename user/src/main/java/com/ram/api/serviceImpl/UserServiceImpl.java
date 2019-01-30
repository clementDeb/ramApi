package com.ram.api.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.api.exception.UserException;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.UserRepository;
import com.ram.api.repositories.superclass.PersonRepository;
import com.ram.api.service.PersonService;
import com.ram.api.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{
	
	private static final String USER_NOT_FOUND_MSG = "user not found";
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PersonService personService;

	@Override
	@Transactional
	public UserEntity createAccount(UserEntity entity) {
		log.debug("in createAccount");
		LocalDateTime creationDate = personService.retrieveCreationDate();
		entity.setCreationDate(creationDate);
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
	public UserEntity retrieveUser(String login) throws UserNotFoundException {
		log.debug("in retrieveUser");
		Optional<UserEntity> userOptional = userRepository.findUserByLogin(login);
		return userOptional.orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MSG));
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
	
	public UserEntity findUserById(int id) throws UserNotFoundException {
		Optional<UserEntity> entity = userRepository.findById(id);
		return entity.orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_MSG));
		
	}

}
