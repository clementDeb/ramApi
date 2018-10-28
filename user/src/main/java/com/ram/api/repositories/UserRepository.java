package com.ram.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ram.api.persistance.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
