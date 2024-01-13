package com.example.taskmanager.status;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class Status {
    private int id;
    private UUID key;
    private String name;

    // Auditing data
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer createdBy;
    private Integer modifiedBy;
    private boolean deleted;

    public Status(int id, UUID key, String name) {
        this.id = id;
        this.key = key;
        this.name = name;
    }

    public Status(UUID key, String name) {
        this.key = key;
        this.name = name;
    }
}
