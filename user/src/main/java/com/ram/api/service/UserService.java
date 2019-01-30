package com.ram.api.service;

import java.util.Optional;

import com.ram.api.exception.UserException;
import com.ram.api.exceptions.UserNotFoundException;
import com.ram.api.persistance.UserEntity;

public interface UserService {
	
	/** Method used to create a user account.
	 * @param user
	 * @return the created user
	 */
	public UserEntity createAccount (UserEntity user);
	
	public UserEntity retrieveUser (String login) throws UserException;
	
	public UserEntity updateUser (UserEntity user);
	
	public void deleteUser (UserEntity user);
	
	public UserEntity findUserById(int id) throws UserNotFoundException;
}
