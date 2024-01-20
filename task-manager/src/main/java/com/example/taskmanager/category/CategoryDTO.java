package com.example.taskmanager.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class CategoryDTO {
    private UUID key;
    private String name;
    private String description;
}
