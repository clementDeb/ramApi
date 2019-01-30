package com.ram.api.repositories;


import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.superclass.PersonRepository;

@Repository
public interface UserRepository extends PersonRepository<UserEntity> {
	UserEntity save(PersonEntity entity);

}
