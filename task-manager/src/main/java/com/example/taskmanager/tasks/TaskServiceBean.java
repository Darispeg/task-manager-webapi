package com.example.taskmanager.tasks;

import com.example.taskmanager.utils.exceptions.TaskNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TaskServiceBean implements TaskService {

    @Autowired
    private TaskMapper _mapper;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDTO> getAll() {
        return taskRepository
                .findAll()
                .stream()
                .map(task -> _mapper.toDTO(task))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO create(TaskDTO task) {
        Task entity = _mapper.toModel(task);
        entity = taskRepository.save(entity);
        return _mapper.toDTO(entity);
    }

    @Override
    public TaskDTO update(TaskDTO dto) {
        Optional<Task> exist = taskRepository.findByKey(dto.getKey());

        if (exist.isEmpty())
            throw new TaskNotFountException(dto.getKey());

        Task entity = exist.get();
        entity.setDescription(dto.getDescription());
        entity.setName(dto.getName());
        entity.setEndDate(dto.getEndDate());
        taskRepository.save(entity);
        return _mapper.toDTO(entity);
    }

    @Override
    public TaskDTO getByKey(UUID key) {
        Optional<Task> entity = taskRepository.findByKey(key);

        if (entity.isEmpty())
            throw new TaskNotFountException(key);

        return _mapper.toDTO(entity.get());
    }

    @Override
    public boolean delete(UUID key) {
        Optional<Task> entity = taskRepository.findByKey(key);

        if (entity.isEmpty())
            throw new TaskNotFountException(key);

        taskRepository.delete(entity.get());
        return true;
    }
}