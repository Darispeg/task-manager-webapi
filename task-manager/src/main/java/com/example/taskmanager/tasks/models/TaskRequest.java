package com.example.taskmanager.tasks.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class TaskRequest {
    private String name;
    private String description;
    private List<UUID> categories;
    private UUID statusKey;
    private Timestamp endDate;
}
