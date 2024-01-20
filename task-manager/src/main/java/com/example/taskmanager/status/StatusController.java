package com.example.taskmanager.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusDTO>> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(statusService.getAll());
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping( value = "/{key}")
    public ResponseEntity<StatusDTO> getByTask(@PathVariable UUID key) {
        try {
            StatusDTO status = statusService.getByKey(key);
            if (status != null)
                return ResponseEntity.status(HttpStatus.OK).body(status);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<StatusDTO> save(@RequestBody StatusDTO request) {
        try {
            StatusDTO statusDTO = statusService.create(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(statusDTO);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping("/{key}")
    public ResponseEntity<StatusDTO> update(@PathVariable UUID key, @RequestBody StatusDTO request) {
        try {
            StatusDTO statusDTO = statusService.update(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(statusDTO);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> delete(@PathVariable UUID key) {
        try {
            statusService.delete(key);
            return ResponseEntity
                    .ok(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}