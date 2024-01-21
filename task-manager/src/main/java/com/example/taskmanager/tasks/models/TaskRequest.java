package com.example.taskmanager.tasks.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class TaskRequest {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 200, min = 3)
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 2000, min = 3)
    private String description;

    private List<UUID> categories;
    private UUID statusKey;
    private Timestamp endDate;
}
