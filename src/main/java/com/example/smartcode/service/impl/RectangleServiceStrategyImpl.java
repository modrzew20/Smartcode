package com.example.smartcode.service.impl;

import com.example.smartcode.common.AbstractShapeService;
import com.example.smartcode.entity.Change;
import com.example.smartcode.entity.figure.Rectangle;
import com.example.smartcode.entity.figure.Shape;
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
public class RectangleServiceStrategyImpl extends AbstractShapeService implements ShapeServiceStrategy {

    private final ShapeRepository shapeRepository;
    private final ChangeRepository changeRepository;

    @Override
    public Shape create(List<Double> parameters) throws NegativeParametersException, InvalidAmountOfParametersException {
        throwsIfInvalidAmountOfParameters(parameters, 2);
        throwsIfNegativeParameters(parameters);

        Rectangle rectangle = new Rectangle();
        rectangle.setLength(parameters.get(0));
        rectangle.setWidth(parameters.get(1));
        return shapeRepository.save(rectangle);
    }

    @Override
    public Shape update(Shape shape, List<Double> parameters) throws NegativeParametersException, InvalidAmountOfParametersException {
        throwsIfInvalidAmountOfParameters(parameters, 2);
        throwsIfNegativeParameters(parameters);
        Rectangle rectangle = (Rectangle) shape;

        Change changeLength = new Change();
        changeLength.setParameterName("lenght");
        changeLength.setParameterNewValue(parameters.get(0));
        changeLength.setParameterOldValue(rectangle.getLength());

        Change changeWidth = new Change();
        changeWidth.setParameterName("width");
        changeWidth.setParameterNewValue(parameters.get(0));
        changeWidth.setParameterOldValue(rectangle.getWidth());

        rectangle.setLength(parameters.get(0));
        rectangle.setWidth(parameters.get(1));
        rectangle.getChanges().add(changeRepository.save(changeLength));
        rectangle.getChanges().add(changeRepository.save(changeWidth));
        return shapeRepository.save(rectangle);
    }

    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("rectangle");
    }
}
