package com.example.smartcode.service.impl;

import com.example.smartcode.common.AbstractShapeService;
import com.example.smartcode.entity.figure.Circle;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.exception.InvalidAmountOfParametersException;
import com.example.smartcode.exception.NegativeParametersException;
import com.example.smartcode.repository.ShapeRepository;
import com.example.smartcode.service.ShapeServiceStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CircleServiceStrategyImpl extends AbstractShapeService implements ShapeServiceStrategy {

    private final ShapeRepository shapeRepository;

    @Override
    public Shape create(List<Double> parameters) throws InvalidAmountOfParametersException, NegativeParametersException {
        throwsIfInvalidAmountOfParameters(parameters, 1);
        throwsIfNegativeParameters(parameters);

        Circle circle = new Circle();
        circle.setType(circle.getClass().getSimpleName());
        circle.setRadius(parameters.get(0));
        return shapeRepository.save(circle);
    }

    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("circle");
    }
}
