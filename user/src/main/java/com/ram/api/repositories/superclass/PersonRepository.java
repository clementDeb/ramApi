package com.ram.api.repositories.superclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;

@Repository
public interface PersonRepository<T extends PersonEntity> extends CrudRepository<T, Long>{

}
