package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.category.CategoryMapper;
import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusDTO;
import com.example.taskmanager.status.StatusMapper;
import com.example.taskmanager.tasks.models.TaskRequest;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TaskMapper {

    @Autowired
    private CategoryMapper _categoryMapper;

    @Autowired
    private StatusMapper _statusMapper;

    public TaskDTO toDTO(Task task) {
        List<CategoryDTO> categories = Optional.ofNullable(task.getCategories())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> _categoryMapper.toDTO(c))
                .toList();

        return new TaskDTO(task.getKey(), task.getName(), task.getDescription(), categories, _statusMapper.toDTO(task.getStatus()), task.getEndDate());
    }

    public Task toModel(TaskDTO dto) {
        List<Category> categories = Optional.ofNullable(dto.getCategories())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> _categoryMapper.toModel(c))
                .toList();

        return new Task(dto.getKey(), dto.getName(), dto.getDescription(), categories, _statusMapper.toModel(dto.getStatus()), dto.getEndDate());
    }

    public TaskDTO toDTO(TaskRequest request) {
        List<CategoryDTO> categories = Optional.ofNullable(request.getCategories())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> new CategoryDTO(c, "", ""))
                .toList();

        StatusDTO status = new StatusDTO(request.getStatusKey(), "");

        return new TaskDTO(null, request.getName(), request.getDescription(), categories, status, request.getEndDate());
    }
}