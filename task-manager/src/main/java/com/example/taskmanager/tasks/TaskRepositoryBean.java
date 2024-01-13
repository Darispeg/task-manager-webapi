package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.status.Status;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Component
public class TaskRepositoryBean implements TaskRepository {

    private static final List<Task> tasks = new ArrayList<>();
    private static final Category category = new Category(1, UUID.fromString("dc451156-9946-4d38-833c-0c171644d5f8"), "Category", "description");

    private static final Status status_1 = new Status(1, UUID.fromString("dc451156-1146-4d38-833c-0c171644d5f8"), "TODO");
    private static final Status status_2 = new Status(2, UUID.fromString("dc451156-6646-4d38-833c-0c171644d5f8"), "IN_PROGRESS");
    private static final Status status_3 = new Status(3, UUID.fromString("dc451156-5546-4d38-833c-0c171644d5f8"), "DONE");


    static {
        tasks.add(new Task(1, UUID.randomUUID(),"Task 1", "Description", category, Timestamp.from(Instant.now()), status_1));
        tasks.add(new Task(2, UUID.randomUUID(),"Task 2", "Description", category, Timestamp.from(Instant.now()), status_2));
        tasks.add(new Task(3, UUID.randomUUID(),"Task 3", "Description", category, Timestamp.from(Instant.now()), status_2));
        tasks.add(new Task(4, UUID.randomUUID(),"Task 4", "Description", category, Timestamp.from(Instant.now()), status_3));
    }

    @Override
    public Collection<Task> findAll() {
        return tasks;
    }

    @Override
    public Task save(Task task) {
        tasks.add(task);
        return task;
    }

    @Override
    public Optional<Task> findOne(Example<Task> of) {
        return Optional.ofNullable(tasks.get(0));
    }

    @Override
    public void delete(Task task) {
        tasks.remove(task);
    }

    @Override
    public Optional<Task> findByUuid(UUID key) {
        return tasks.stream().filter(task -> task.getKey().equals(key)).findAny();
    }
}
