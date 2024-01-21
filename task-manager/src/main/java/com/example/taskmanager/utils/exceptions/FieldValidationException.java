package com.example.taskmanager.utils.exceptions;

import java.util.Date;
import java.util.Map;

public class FieldValidationException  extends ManagerException{
    private Map<String, String> fieldErrors;

    public FieldValidationException(Date timestamp, String message, String path, Integer status, Map<String, String> fieldErrors) {
        super(timestamp, message, path, status);
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}
