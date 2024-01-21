package com.example.taskmanager.status;

import com.example.taskmanager.utils.exceptions.StatusNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class StatusMapper {

    @Autowired
    private StatusRepository statusRepository;

    public StatusDTO toDTO(Status status) {
        return new StatusDTO(status.getKey(), status.getName());
    }

    public Status toModel(StatusDTO dto) {
        Optional<Status> entity = statusRepository.findByKey(dto.getKey());
        return entity.orElseGet(() -> new Status(dto.getKey(), dto.getName()));
    }

    public Status toModel(UUID key) {
        Optional<Status> entity = statusRepository.findByKey(key);

        if (entity.isEmpty())
            throw new StatusNotFoundException(key);

        return entity.orElse(null);
    }
}
