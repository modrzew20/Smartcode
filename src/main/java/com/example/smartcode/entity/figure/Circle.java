package com.example.smartcode.entity.figure;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Circle extends Shape {

    private double radius;

    @Override
    protected double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    protected double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

