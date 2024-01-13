package com.example.taskmanager.category;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter @Setter
public class Category {
    private int id;
    private UUID key;
    private String name;
    private String description;

    // Auditing data
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer createdBy;
    private Integer modifiedBy;
    private boolean deleted;

    public Category(int id, UUID key, String name, String description) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.description = description;
    }

    public Category( UUID key, String name, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
    }
}
