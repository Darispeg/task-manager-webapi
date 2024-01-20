package com.example.taskmanager.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class StatusServiceBean implements StatusService {

    @Autowired
    private StatusMapper _mapper;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<StatusDTO> getAll() {
        return statusRepository
                .findAll()
                .stream()
                .map(status -> _mapper.toDTO(status))
                .collect(Collectors.toList());
    }

    @Override
    public StatusDTO create(StatusDTO dto) {
        Status entity = _mapper.toModel(dto);
        entity = statusRepository.save(entity);
        return _mapper.toDTO(entity);
    }

    @Override
    public StatusDTO update(StatusDTO dto) {
        Optional<Status> exist = statusRepository.findByKey(dto.getKey());

        if(exist.isPresent()) {
            Status entity = exist.get();
            entity.setName(dto.getName());
            statusRepository.save(entity);
            return _mapper.toDTO(entity);
        }

        return null;
    }

    @Override
    public StatusDTO getByKey(UUID key) {
        Optional<Status> entity = statusRepository.findByKey(key);
        return entity.isPresent() ? _mapper.toDTO(entity.get()) : null;
    }

    @Override
    public boolean delete(UUID key) {
        Optional<Status> entity = statusRepository.findByKey(key);

        if(entity.isPresent()) {
            statusRepository.delete(entity.get());
            return true;
        }

        return false;
    }
}
