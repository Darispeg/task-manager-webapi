package com.example.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface TaskService {
    List<TaskDTO> getAll();
    TaskDTO create(TaskDTO task);
    TaskDTO update(TaskDTO dto);
    TaskDTO getByKey(UUID key);
    boolean delete(UUID key);
}
