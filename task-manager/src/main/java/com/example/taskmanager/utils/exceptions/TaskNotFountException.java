package com.example.taskmanager.utils.exceptions;

import java.util.UUID;

public class TaskNotFountException extends EntityNotFoundException {
    public TaskNotFountException(UUID key) {
        super(key, "Task");
    }
}
