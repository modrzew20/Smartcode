package com.example.smartcode.service.impl;

import com.example.smartcode.entity.figure.Circle;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.repository.ShapeRepository;
import com.example.smartcode.service.AbstractShapeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CircleServiceImpl implements AbstractShapeServiceInterface {

    private final ShapeRepository shapeRepository;

    @Override
    public Shape create(List<Double> parameters) {
        Circle circle = new Circle();
        circle.setType(circle.getClass().getSimpleName());
        circle.setRadius(parameters.get(0));
        return shapeRepository.save(circle);
    }
}
