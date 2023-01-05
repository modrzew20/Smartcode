package com.example.smartcode.service.impl;

import com.example.smartcode.common.AbstractShapeService;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.entity.figure.Square;
import com.example.smartcode.exception.InvalidAmountOfParametersException;
import com.example.smartcode.exception.NegativeParametersException;
import com.example.smartcode.repository.ShapeRepository;
import com.example.smartcode.service.ShapeServiceStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SquareServiceStrategyImpl extends AbstractShapeService implements ShapeServiceStrategy {

    private final ShapeRepository shapeRepository;

    public Shape create(List<Double> parameters) throws NegativeParametersException, InvalidAmountOfParametersException {
        throwsIfInvalidAmountOfParameters(parameters, 1);
        throwsIfNegativeParameters(parameters);

        Square square = new Square();
        square.setType(square.getClass().getSimpleName());
        square.setWidth(parameters.get(0));
        return shapeRepository.save(square);
    }


    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("square");
    }
}
