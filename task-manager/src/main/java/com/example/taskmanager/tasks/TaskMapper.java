package com.example.taskmanager.tasks;

import com.example.taskmanager.category.CategoryMapper;
import com.example.taskmanager.status.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    @Autowired
    private CategoryMapper _categoryMapper;

    @Autowired
    private StatusMapper _statusMapper;

    public TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getKey(), task.getName(), task.getDescription(), task.getCategory().getKey(), _statusMapper.toDTO(task.getStatus()), task.getEndDate());
    }

    public Task toModel(TaskDTO dto) {
        return new Task(dto.getKey(), dto.getName(), dto.getDescription(), _categoryMapper.toModel(dto.getCategoryKey()), _statusMapper.toModel(dto.getStatus()), dto.getEndDate());
    }
}