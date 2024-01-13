package com.example.taskmanager.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                        .body(taskService.getAll());
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
        }
    }

    @GetMapping( value = "/{key}")
    public ResponseEntity<TaskDTO> getByTask(@PathVariable UUID key) {
        try {
            TaskDTO task = taskService.getByKey(key);
            if (task != null)
                return ResponseEntity.status(HttpStatus.OK).body(task);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<TaskDTO> save(@RequestBody TaskDTO request) {
        try {
            TaskDTO taskDTO = taskService.create(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                        .body(taskDTO);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
        }
    }

    @PutMapping("/{key}")
    public ResponseEntity<TaskDTO> update(@PathVariable UUID key, @RequestBody TaskDTO request) {
        try {
            TaskDTO taskDTO = taskService.update(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                        .body(taskDTO);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
        }
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> delete(@PathVariable UUID key) {
        try {
            taskService.delete(key);
            return ResponseEntity
                    .ok(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
        }
    }
}