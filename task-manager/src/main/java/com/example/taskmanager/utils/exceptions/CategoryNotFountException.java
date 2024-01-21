package com.example.taskmanager.utils.exceptions;

import java.util.UUID;

public class CategoryNotFountException extends EntityNotFoundException {
    public CategoryNotFountException(UUID key) {
        super(key, "Category");
    }
}