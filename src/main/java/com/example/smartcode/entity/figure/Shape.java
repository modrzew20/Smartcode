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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class Shape extends AbstractEntity {

    @Column(nullable = false)
    protected String type;

    @Column(nullable = false)
    protected double area;

    @Column(nullable = false)
    protected double perimeter;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedBy
    private String lastModifiedBy;

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
