package com.example.taskmanager.status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class StatusDTO {
    private UUID key;

    @NotNull(message = "Name of status is required")
    @NotBlank(message = "Name of status cannot be blank")
    @Size(max = 200, min = 3)
    private String name;
}
