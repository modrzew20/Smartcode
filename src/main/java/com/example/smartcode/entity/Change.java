package com.example.smartcode.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Change {

    @Id
    @GeneratedValue
    private UUID id;

    @CreatedDate
    private LocalDateTime changedDate;

    @CreatedBy
    private String changedBy;

    @Column(nullable = false)
    private String parameterName;

    @Column(nullable = false)
    private double parameterOldValue;

    @Column(nullable = false)
    private double parameterNewValue;

}
