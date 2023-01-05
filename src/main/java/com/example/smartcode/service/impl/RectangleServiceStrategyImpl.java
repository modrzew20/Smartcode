package com.example.smartcode.service.impl;

import com.example.smartcode.common.AbstractShapeService;
import com.example.smartcode.entity.figure.Rectangle;
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
public class RectangleServiceStrategyImpl extends AbstractShapeService implements ShapeServiceStrategy {

    private final ShapeRepository shapeRepository;

    @Override
    public Shape create(List<Double> parameters) throws NegativeParametersException, InvalidAmountOfParametersException {
        throwsIfInvalidAmountOfParameters(parameters, 2);
        throwsIfNegativeParameters(parameters);

        Rectangle rectangle = new Rectangle();
        rectangle.setType(rectangle.getClass().getSimpleName());
        rectangle.setLength(parameters.get(0));
        rectangle.setWidth(parameters.get(1));
        return shapeRepository.save(rectangle);
    }

    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("rectangle");
    }
}
