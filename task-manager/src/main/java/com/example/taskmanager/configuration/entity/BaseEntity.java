package com.example.taskmanager.configuration.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter @Setter
public abstract class BaseEntity {
    private int id;
    private UUID key;

    // Auditing data
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Integer createdBy;
    private Integer modifiedBy;
    private boolean deleted;
}
