package com.example.taskmanager.status;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StatusRepositoryBean implements StatusRepository {

    private static final List<Status> statusList = new ArrayList<>();

    static {
        statusList.add(new Status(1, UUID.fromString("dc451156-1146-4d38-833c-0c171644d5f8"), "TODO"));
        statusList.add(new Status(2, UUID.fromString("dc451156-6646-4d38-833c-0c171644d5f8"), "IN_PROGRESS"));
        statusList.add(new Status(3, UUID.fromString("dc451156-5546-4d38-833c-0c171644d5f8"), "DONE"));
    }

    @Override
    public Collection<Status> findAll() {
        return statusList;
    }

    @Override
    public Status save(Status status) {
        statusList.add(status);
        return status;
    }

    @Override
    public Optional<Status> findOne(Example<Status> of) {
        return Optional.empty();
    }

    @Override
    public void delete(Status status) {
        statusList.remove(status);
    }

    @Override
    public Optional<Status> findByUuid(UUID key) {
        return statusList.stream()
                .filter(status -> status.getKey().equals(key))
                .findAny();
    }
}
