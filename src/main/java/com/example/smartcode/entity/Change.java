package com.example.smartcode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
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
