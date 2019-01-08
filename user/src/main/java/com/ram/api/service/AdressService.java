package com.ram.api.service;


import com.ram.api.persistance.AdressEntity;

public interface AdressService {
	
	/** Method used to create a user account.
	 * @param user
	 * @return the created user
	 */
	public AdressEntity createAdress (AdressEntity adress);
	
	public AdressEntity retrieveAdress (int adressId);
	
	public AdressEntity updateAdress (AdressEntity adress);
	
	public void deleteAdress (int adressId);

}
