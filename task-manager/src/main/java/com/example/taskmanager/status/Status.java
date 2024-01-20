package com.example.taskmanager.status;

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
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE Status SET deleted = true WHERE status_id=?")
@Where(clause = "deleted = false")
@Getter @Setter @NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue
    private Long status_id;

    @Column
    @UuidGenerator
    private UUID key;

    @Column(nullable = false, length = 200)
    private String name;

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
    @OneToMany(mappedBy = "status", cascade = CascadeType.PERSIST)
    private List<Task> tasks;

    public Status(Long id, UUID key, String name) {
        this.status_id = id;
        this.key = key;
        this.name = name;
    }

    public Status(UUID key, String name) {
        this.key = key;
        this.name = name;
    }
}
