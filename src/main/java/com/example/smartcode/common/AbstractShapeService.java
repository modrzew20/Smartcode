package com.example.smartcode.common;

import com.example.smartcode.exception.InvalidAmountOfParametersException;
import com.example.smartcode.exception.NegativeParametersException;

import java.util.List;

public abstract class AbstractShapeService {

    protected void throwsIfInvalidAmountOfParameters(List<Double> parameters, int expectedAmount) throws InvalidAmountOfParametersException {
        if (parameters.size() != expectedAmount) {
            throw new InvalidAmountOfParametersException(expectedAmount, parameters.size());
        }
    }

    protected void throwsIfNegativeParameters(List<Double> parameters) throws NegativeParametersException {
        for (Double parameter : parameters) {
            if (parameter < 0) {
                throw new NegativeParametersException(parameter);
            }
        }
    }
}
