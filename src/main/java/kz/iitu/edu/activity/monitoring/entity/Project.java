package kz.iitu.edu.activity.monitoring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "project")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "manager_id", nullable = false)
    private String managerId;

    @Column(name = "chief_editor_id", nullable = false, unique = true)
    private String chiefEditorId;

    @Column(name = "target_date", nullable = false)
    private LocalDate targetDate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "project")
    private List<Activity> activities;

    @OneToMany(mappedBy = "project")
    private List<ExtraChiefEditor> extraChiefEditors;

    @PrePersist
    private void setCreatedAtAndUpdatedAt() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void setUpdatedAt() {
        updatedAt = LocalDateTime.now();
    }
}
