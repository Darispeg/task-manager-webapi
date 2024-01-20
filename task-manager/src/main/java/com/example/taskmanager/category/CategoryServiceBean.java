package com.example.taskmanager.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CategoryServiceBean implements CategoryService {

    @Autowired
    private CategoryMapper _mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(category -> _mapper.toDTO(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        Category entity = _mapper.toModel(dto);
        entity = categoryRepository.save(entity);
        return _mapper.toDTO(entity);
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {
        Optional<Category> exist = categoryRepository.findByKey(dto.getKey());

        if(exist.isPresent()) {
            Category entity = exist.get();
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            categoryRepository.save(entity);
            return _mapper.toDTO(entity);
        }

        return null;
    }

    @Override
    public CategoryDTO getByKey(UUID key) {
        Optional<Category> entity = categoryRepository.findByKey(key);
        return entity.isPresent() ? _mapper.toDTO(entity.get()) : null;
    }

    @Override
    public boolean delete(UUID key) {
        Optional<Category> entity = categoryRepository.findByKey(key);

        if(entity.isPresent()) {
            categoryRepository.delete(entity.get());
            return true;
        }

        return false;
    }
}