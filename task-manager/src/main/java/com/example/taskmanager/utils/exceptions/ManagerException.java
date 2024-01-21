package com.example.taskmanager.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class ManagerException {
    private Date timestamp;
    private String message;
    private String path;
    private Integer status;
}
