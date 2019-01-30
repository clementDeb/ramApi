package com.ram.api.repositories.superclass;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import com.ram.api.persistance.PersonEntity;
import com.ram.api.persistance.UserEntity;

@NoRepositoryBean
public interface PersonRepository<T extends PersonEntity> extends CrudRepository<T, Long>{

	@Query("SELECT p FROM #{#entityName} as p WHERE p.id = :id")
	Optional<T> findById(@Param(value = "id") int id);
	
}
