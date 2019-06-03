package com.ram.api.service;


import com.ram.api.exceptions.AdressExistException;
import com.ram.api.exceptions.AdressNotFoundException;
import com.ram.api.persistance.AdressEntity;

public interface AdressService {
	
	/** Method used to create an adress account.
	 * @param AdressEntity
	 * @return the created adress
	 */
	public AdressEntity createAdress (AdressEntity adress) throws AdressExistException;
	
	public AdressEntity retrieveAdress (long adressId) throws AdressNotFoundException;
	
	public AdressEntity updateAdress (AdressEntity adress);
	
	public void deleteAdress (AdressEntity adress);


}
