package com.example.taskmanager.tasks;

import com.example.taskmanager.configuration.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class Task extends BaseEntity {
    private String name;
    private String description;
    private String category;
    private Timestamp endDate;
    private String status;
}