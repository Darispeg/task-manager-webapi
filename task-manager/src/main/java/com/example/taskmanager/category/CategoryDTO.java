package com.example.taskmanager.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class CategoryDTO {
    private UUID key;

    @NotNull(message = "Name of the category is required")
    @NotBlank(message = "Name of category cannot be blank")
    @Size(max = 200, min = 3)
    private String name;

    @NotBlank(message = "Description of the category cannot be blank")
    @Size(max = 2000, min = 3)
    private String description;
}
