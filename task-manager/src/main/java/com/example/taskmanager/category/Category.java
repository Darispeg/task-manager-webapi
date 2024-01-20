package com.example.taskmanager.category;

import com.example.taskmanager.tasks.Task;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE Category SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@Getter @Setter @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private Long category_id;

    @Column
    @UuidGenerator
    private UUID key;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = true, length = 2000)
    private String description;

    /** Auditing data **/
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

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT '0'")
    private boolean deleted;

    /** Relationship **/
    @ManyToMany(mappedBy = "categories")
    private Set<Task> tasks = new HashSet<>();

    public Category(Long id, UUID key, String name, String description) {
        this.category_id = id;
        this.key = key;
        this.name = name;
        this.description = description;
    }

    public Category( UUID key, String name, String description) {
        this.key = key;
        this.name = name;
        this.description = description;
    }
}
