package com.example.taskmanager.tasks;

import com.example.taskmanager.status.StatusDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
public class TaskDTO {
    private UUID key;
    private String name;
    private String description;
    private UUID categoryKey;
    private StatusDTO status;
    private Timestamp endDate;
}