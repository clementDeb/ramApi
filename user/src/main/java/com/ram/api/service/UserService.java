package com.ram.api.service;

import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;

public interface UserService {
	
	/** Method used to create a user account.
	 * @param user
	 * @return the created user
	 */
	public UserEntity createAccount (UserEntity user);
	
	public UserEntity retrieveUser (String login);
	
	public UserEntity updateUser (UserEntity user);
	
	public void deleteUser (UserEntity user);
}
