package com.ram.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ram.api.persistance.AdressEntity;

@Repository
public interface AdressRepository extends CrudRepository<AdressEntity, Long>{

}
