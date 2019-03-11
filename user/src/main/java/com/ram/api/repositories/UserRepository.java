package com.ram.api.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;
import com.ram.api.repositories.superclass.PersonRepository;


@Repository
public interface UserRepository extends PersonRepository<UserEntity> {
	
	UserEntity save(PersonEntity entity);
	
	@Query("SELECT u FROM UserEntity as u WHERE u.login = :login")
	Optional<UserEntity> findUserByLogin(@Param(value = "login") String login);
	
	@Query("SELECT u.login FROM UserEntity as u")
	List<String> findAllLogin();

}
