package com.example.smartcode.entity;

import com.example.smartcode.entity.figure.Shape;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class ShapeModification {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToMany
    private List<Shape> shapes = new ArrayList<>();

    @CreatedDate
    private LocalDateTime changedDate;

    @ManyToOne
    @CreatedBy
    private Account changedBy;

    @Column(nullable = false)
    private String parameterName;

    @Column(nullable = false)
    private double parameterOldValue;

    @Column(nullable = false)
    private double parameterNewValue;

}
