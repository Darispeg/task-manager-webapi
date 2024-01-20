package com.example.taskmanager.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findAll();
    Status save(Status status);
    void delete(Status status);
    Optional<Status> findByKey(UUID key);
}
