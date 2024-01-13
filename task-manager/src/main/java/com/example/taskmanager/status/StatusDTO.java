package com.example.taskmanager.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class StatusDTO {
    private UUID key;
    private String name;
}
