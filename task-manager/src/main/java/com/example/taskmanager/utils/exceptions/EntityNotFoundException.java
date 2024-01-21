package com.example.taskmanager.utils.exceptions;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(UUID key, String entityName) {
        super(String.format("Entity: %s not found with key(s)=%s", entityName, key));
    }
}
