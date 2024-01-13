package com.example.taskmanager.category;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CategoryRepositoryBean implements CategoryRepository {

    private static final List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category(1, UUID.fromString("dc451156-9946-4d38-833c-0c171644d5f8"), "Category 1", "description"));
        categories.add(new Category(2, UUID.randomUUID(),"Category 2", "Description"));
        categories.add(new Category(3, UUID.randomUUID(),"Category 3", "Description"));
        categories.add(new Category(4, UUID.randomUUID(),"Category 4", "Description"));
        categories.add(new Category(5, UUID.randomUUID(),"Category 5", "Description"));
    }

    @Override
    public Collection<Category> findAll() {
        return categories;
    }

    @Override
    public Category save(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public Optional<Category> findOne(Example<Category> of) {
        return Optional.empty();
    }

    @Override
    public void delete(Category category) {
        categories.remove(category);
    }

    @Override
    public Optional<Category> findByUuid(UUID key) {
        return categories.stream()
                .filter(category -> category.getKey().equals(key))
                    .findAny();
    }
}
