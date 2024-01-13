package com.example.taskmanager.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CategoryService {
    List<CategoryDTO> getAll();
    CategoryDTO create(CategoryDTO dto);
    CategoryDTO update(CategoryDTO dto);
    CategoryDTO getByKey(UUID key);
    boolean delete(UUID key);
}
