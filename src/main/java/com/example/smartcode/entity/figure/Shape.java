package com.example.smartcode.entity.figure;

import com.example.smartcode.common.AbstractEntity;
import com.example.smartcode.entity.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public abstract class Shape extends AbstractEntity {

    @Column(nullable = false)
    @Setter
    protected double area;

    @Column(nullable = false)
    @Setter
    protected double perimeter;

    @ManyToOne
    @CreatedBy
    private Account createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne
    @LastModifiedBy
    private Account lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @PrePersist
    private void setAreaAndPerimeter() {
        setArea(calculateArea());
        setPerimeter(calculatePerimeter());
    }

    protected abstract double calculateArea();

    protected abstract double calculatePerimeter();
}
