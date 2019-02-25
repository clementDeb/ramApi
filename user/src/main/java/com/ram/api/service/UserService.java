package com.ram.api.service;

import java.util.List;
import java.util.Optional;

import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.persistance.AdressEntity;
import com.ram.api.persistance.UserEntity;

public interface UserService {
	
	/** Method used to create a user account.
	 * @param user
	 * @return the created user
	 */
	public UserEntity createAccount (UserEntity user);
	
	public UserEntity retrieveUser (String login) throws UserNotFoundException;
	
	public UserEntity updateUser (UserEntity user);
	
	public void deleteUser (UserEntity user);
	
	public UserEntity findUserById(long id) throws UserNotFoundException;
	
	public List<AdressEntity> retrieveAdressesByUserId (long id);
}
