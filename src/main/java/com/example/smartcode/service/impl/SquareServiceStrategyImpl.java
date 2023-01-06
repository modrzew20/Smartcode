package com.example.smartcode.service.impl;

import com.example.smartcode.common.AbstractShapeService;
import com.example.smartcode.entity.Change;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.entity.figure.Square;
import com.example.smartcode.exception.InvalidAmountOfParametersException;
import com.example.smartcode.exception.NegativeParametersException;
import com.example.smartcode.repository.ChangeRepository;
import com.example.smartcode.repository.ShapeRepository;
import com.example.smartcode.service.ShapeServiceStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(noRollbackFor = Exception.class)
public class SquareServiceStrategyImpl extends AbstractShapeService implements ShapeServiceStrategy {

    private final ShapeRepository shapeRepository;
    private final ChangeRepository changeRepository;

    public Shape create(List<Double> parameters) throws NegativeParametersException, InvalidAmountOfParametersException {
        throwsIfInvalidAmountOfParameters(parameters, 1);
        throwsIfNegativeParameters(parameters);
        Square square = new Square();
        square.setType(square.getClass().getSimpleName().toLowerCase());
        square.setWidth(parameters.get(0));
        return shapeRepository.save(square);
    }

    @Override
    public Shape update(Shape shape, List<Double> parameters) throws NegativeParametersException, InvalidAmountOfParametersException {
        throwsIfInvalidAmountOfParameters(parameters, 1);
        throwsIfNegativeParameters(parameters);
        Square square = (Square) shape;


        Change change = new Change();
        change.setParameterName("width");
        change.setParameterNewValue(parameters.get(0));
        change.setParameterOldValue(square.getWidth());

        square.setWidth(parameters.get(0));
        square.getChanges().add(changeRepository.save(change));
        return shapeRepository.save(square);
    }


    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("square");
    }
}
