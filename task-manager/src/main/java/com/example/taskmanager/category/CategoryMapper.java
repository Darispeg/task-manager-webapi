package com.example.taskmanager.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CategoryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getKey(), category.getName(), category.getDescription());
    }

    public Category toModel(CategoryDTO dto) {
        return new Category(dto.getKey(), dto.getName(), dto.getDescription());
    }

    public Category toModel(UUID key) {
        Optional<Category> entity = categoryRepository.findByUuid(key);
        return entity.isPresent() ? entity.get() : null;
    }
}