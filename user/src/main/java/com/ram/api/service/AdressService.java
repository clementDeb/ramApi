package com.ram.api.service;


import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.persistance.AdressEntity;

public interface AdressService {
	
	/** Method used to create a user account.
	 * @param user
	 * @return the created user
	 */
	public AdressEntity createAdress (AdressEntity adress);
	
	public AdressEntity retrieveAdress (long adressId) throws AdressNotFoundException;
	
	public AdressEntity updateAdress (AdressEntity adress);
	
	public void deleteAdress (AdressEntity adress);

}
