package com.ram.api.repositories.superclass;

import org.springframework.data.repository.CrudRepository;

import com.ram.api.persistance.AttachmentEntity;

public interface AttachmentRepository<T extends AttachmentEntity> extends CrudRepository<T, Long> {

}
