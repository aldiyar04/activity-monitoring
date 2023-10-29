package kz.iitu.edu.activity.monitoring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "activity")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String html;

    //enum
    @Column(nullable = false)
    private String language;

    //enum
    @Column(name = "target_language", nullable = false)
    private String targetLanguage;

    @Column(name = "translator_id", nullable = false)
    private String translatorId;

    //enum
    @Column(nullable = false)
    private String status;

    @Column(name = "target_title")
    private String targetTitle;

    @Column(name = "target_html")
    @Lob
    private String targetHtml;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "activity")
    private Set<ActivityLog> activityLogs;

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
