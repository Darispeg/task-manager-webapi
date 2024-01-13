package com.example.taskmanager.status;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StatusService {
    List<StatusDTO> getAll();
    StatusDTO create(StatusDTO dto);
    StatusDTO update(StatusDTO dto);
    StatusDTO getByKey(UUID key);
    boolean delete(UUID key);
}
