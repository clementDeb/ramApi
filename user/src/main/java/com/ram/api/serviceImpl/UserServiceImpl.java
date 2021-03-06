package com.ram.api.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ram.api.constants.ExceptionMessage;
import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.exceptions.EmailExistException;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.AdressRepository;
import com.ram.api.repositories.UserRepository;
import com.ram.api.service.PersonService;
import com.ram.api.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@CacheConfig(cacheManager="userCacheManager")
@RequiredArgsConstructor(onConstructor=@__({@Autowired}))
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	private final AdressRepository adressRepository;

	private final PersonService personService;
	
	private final LoginManager loginManager;

	@Override
	@Transactional
	public UserEntity createAccount(UserEntity entity) throws EmailExistException {
		log.debug("in createAccount");
		boolean loginExist = loginExist(entity.getLogin(), loginManager);
		if (!loginExist) {
			entity.setCreationDate(personService.retrieveCreationDate());
			entity.setPassword(loginManager.encode(entity.getPassword()));
			return userRepository.save(entity);			
		}else {
			throw new EmailExistException(ExceptionMessage.EMAIL_ALREADY_EXISTS);
		}
	}
	
	private boolean loginExist (String login, LoginManager accManager) {
		List<String> logins = userRepository.findAllLogin();		
		return accManager.loginExist(login, logins);
	}

	@Override
	@Transactional
	@Cacheable(value="user")
	public UserEntity retrieveUser(String login) throws UserNotFoundException {
		log.debug("in retrieveUser");
		Optional<UserEntity> userOptional = userRepository.findUserByLogin(login);
		return userOptional.orElseThrow(() -> new UserNotFoundException(ExceptionMessage.USER_NOT_FOUND_MSG));
	}

	@Override
	@Transactional
	@CachePut(value="user")
	public UserEntity updateUser(UserEntity entity) {
		log.debug("in updateUser");
		return userRepository.save(entity);
	}

	@Override
	@CacheEvict(value="user")
	public void deleteUser(UserEntity entity) {
		log.debug("in deleteUser");
		userRepository.delete(entity);		
	}
	
	@Cacheable(value="user")
	@Transactional
	public UserEntity findUserById(long id) throws UserNotFoundException {
		Optional<UserEntity> entity = userRepository.findById(id);
		return entity.orElseThrow(() -> new UserNotFoundException(ExceptionMessage.USER_NOT_FOUND_MSG));		
	}
	
	@Override
	@Transactional
	@CachePut(value="user")
	public List<AdressEntity> retrieveAdressesByUserId (long id) throws AdressNotFoundException{
		List <AdressEntity> listAdress = adressRepository.findAllByPersonId(id);
		if (!listAdress.isEmpty()) {
			listAdress = listAdress.stream()
						.sorted()
						.collect(Collectors.toList());
		return listAdress;
		} else {
			throw new AdressNotFoundException(ExceptionMessage.ADRESS_NOT_FOUND);
		}
	}
}
