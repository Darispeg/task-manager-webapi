package com.example.taskmanager.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoryService.getAll());
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping( value = "/{key}")
    public ResponseEntity<CategoryDTO> getByTask(@PathVariable UUID key) {
        try {
            CategoryDTO category = categoryService.getByKey(key);
            if (category != null)
                return ResponseEntity.status(HttpStatus.OK).body(category);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO request) {
        try {
            CategoryDTO categoryDTO = categoryService.create(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoryDTO);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping("/{key}")
    public ResponseEntity<CategoryDTO> update(@PathVariable UUID key, @RequestBody CategoryDTO request) {
        try {
            CategoryDTO categoryDTO = categoryService.update(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoryDTO);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> delete(@PathVariable UUID key) {
        try {
            categoryService.delete(key);
            return ResponseEntity
                    .ok(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
