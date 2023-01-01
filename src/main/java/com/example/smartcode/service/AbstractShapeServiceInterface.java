package com.example.smartcode.service;

import com.example.smartcode.entity.figure.Shape;

import java.util.List;

public interface AbstractShapeServiceInterface {

    Shape create(List<Double> parameters);

}
