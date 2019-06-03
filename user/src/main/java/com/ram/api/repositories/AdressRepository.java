package com.ram.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ram.api.persistance.AdressEntity;

@Repository
public interface AdressRepository extends CrudRepository<AdressEntity, Long>{
	
	@Query("SELECT adr FROM AdressEntity as adr WHERE adr.personId = :personId")
	List<AdressEntity> findAllByPersonId(@Param(value="personId") long personId);
}
