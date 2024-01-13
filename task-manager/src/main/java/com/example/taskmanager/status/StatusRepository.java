package com.example.taskmanager.status;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatusRepository {
    Collection<Status> findAll();
    Status save(Status status);
    Optional<Status> findOne(Example<Status> of);
    void delete(Status status);
    Optional<Status> findByUuid(UUID key);
}
