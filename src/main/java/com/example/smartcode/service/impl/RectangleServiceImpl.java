package com.example.smartcode.service.impl;

import com.example.smartcode.entity.figure.Rectangle;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.repository.ShapeRepository;
import com.example.smartcode.service.AbstractShapeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RectangleServiceImpl implements AbstractShapeServiceInterface {

    private final ShapeRepository shapeRepository;

    @Override
    public Shape create(List<Double> parameters) {
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(parameters.get(0));
        rectangle.setWidth(parameters.get(1));
        return shapeRepository.save(rectangle);
    }

}
