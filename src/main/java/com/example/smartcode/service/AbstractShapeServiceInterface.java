package com.example.smartcode.service;

import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.exception.InvalidAmountOfParametersException;
import com.example.smartcode.exception.NegativeParametersException;
import org.springframework.plugin.core.Plugin;

import java.util.List;

public interface AbstractShapeServiceInterface extends Plugin<String> {

    Shape create(List<Double> parameters) throws NegativeParametersException, InvalidAmountOfParametersException;

}
