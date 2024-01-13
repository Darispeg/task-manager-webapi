package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data @AllArgsConstructor
public class Task {
    private int id;
    private UUID key;
    private boolean deleted;
    private String name;
    private String description;
    private Category category;
    private Timestamp endDate;
    private Status status;

    // Auditing data
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer createdBy;
    private Integer modifiedBy;

    public Task(int id, UUID key, String name, String description, Category category, Timestamp endDate, Status status) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.description = description;
        this.category = category;
        this.endDate = endDate;
        this.status = status;
    }

    public Task(UUID key, String name, String description, Category category, Status status, Timestamp endDate) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.category = category;
        this.endDate = endDate;
        this.status = status;
    }
}