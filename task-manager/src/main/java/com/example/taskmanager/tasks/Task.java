package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.solutions.Solution;
import com.example.taskmanager.status.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE Task SET deleted = true WHERE task_id=?")
@Where(clause = "deleted = false")
@Data @AllArgsConstructor @NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long task_id;

    @Column
    @UuidGenerator
    private UUID key;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String description;

    @Column
    private Timestamp endDate;

    // Auditing data
    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT '0'")
    private boolean deleted;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Timestamp createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private Timestamp modifiedDate;

    @CreatedBy
    private Integer createdBy;

    @LastModifiedBy
    private Integer modifiedBy;

    /** Relationship **/
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.PERSIST })
    @JoinTable(name = "task_category",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "status_id", nullable = true)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solution_id")
    private Solution solution;

    public Task(Long id, UUID key, String name, String description, List<Category> categories, Timestamp endDate, Status status) {
        this.task_id = id;
        this.key = key;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.endDate = endDate;
        this.status = status;
    }

    public Task(UUID key, String name, String description, List<Category> categories, Status status, Timestamp endDate) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.endDate = endDate;
        this.status = status;
    }
}