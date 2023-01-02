package com.example.smartcode.service.impl;

import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.entity.figure.Square;
import com.example.smartcode.repository.ShapeRepository;
import com.example.smartcode.service.AbstractShapeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SquareServiceImpl implements AbstractShapeServiceInterface {

    private final ShapeRepository shapeRepository;

    public Shape create(List<Double> parameters) {
        Square square = new Square();
        square.setType(square.getClass().getSimpleName());
        square.setSide(parameters.get(0));
        return shapeRepository.save(square);
    }


    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("square");
    }
}
