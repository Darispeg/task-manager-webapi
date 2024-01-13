package com.example.taskmanager.tasks;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository {
    Collection<Task> findAll();
    Task save(Task task);
    Optional<Task> findOne(Example<Task> of);
    void delete(Task task);
    Optional<Task> findByUuid(UUID key);
}
