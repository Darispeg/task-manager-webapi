package com.example.taskmanager.tasks;

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
        entity.setKey(UUID.randomUUID()); // TODO: Delete line
        entity = taskRepository.save(entity);
        return _mapper.toDTO(entity);
    }

    @Override
    public TaskDTO update(TaskDTO dto) {
        Optional<Task> exist = taskRepository.findByUuid(dto.getKey());

        if (exist.isPresent())
        {
            Task entity = exist.get();
            entity.setDescription(dto.getDescription());
            entity.setName(dto.getName());
            entity.setEndDate(dto.getEndDate());

            taskRepository.save(entity);

            return _mapper.toDTO(entity);
        }

        return null;
    }

    @Override
    public TaskDTO getByKey(UUID key) {
        Optional<Task> entity = taskRepository.findByUuid(key);
        return entity.isPresent() ? _mapper.toDTO(entity.get()) : null;
    }

    @Override
    public boolean delete(UUID key) {
        Optional<Task> entity = taskRepository.findByUuid(key);

        if (entity.isPresent())
        {
            taskRepository.delete(entity.get());
            return true;
        }

        return false;
    }
}