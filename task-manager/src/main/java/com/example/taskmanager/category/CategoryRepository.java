package com.example.taskmanager.category;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository {
    Collection<Category> findAll();
    Category save(Category category);
    Optional<Category> findOne(Example<Category> of);
    void delete(Category category);
    Optional<Category> findByUuid(UUID key);
}
