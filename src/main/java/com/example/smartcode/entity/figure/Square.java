package com.example.smartcode.entity.figure;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Square extends Shape {

    private double side;

    @Override
    protected double calculateArea() {
        return side * side;
    }

    @Override
    protected double calculatePerimeter() {
        return 4 * side;
    }
}
