package com.ram.api.repositories.superclass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ram.api.persistance.PersonEntity;

@Repository
public interface PersonRepository<T extends PersonEntity> extends CrudRepository<T, Long>{

}
