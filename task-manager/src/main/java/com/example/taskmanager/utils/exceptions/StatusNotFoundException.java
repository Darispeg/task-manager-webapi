package com.example.taskmanager.utils.exceptions;

import java.util.UUID;

public class StatusNotFoundException extends EntityNotFoundException {
    public StatusNotFoundException(UUID key) {
        super(key, "Status");
    }
}