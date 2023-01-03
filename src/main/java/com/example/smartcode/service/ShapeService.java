package com.example.smartcode.service;

import com.example.smartcode.dto.SearchShapeParam;
import com.example.smartcode.entity.figure.Shape;

import java.util.List;

public interface ShapeService {

    List<Shape> getAll(SearchShapeParam searchShapeParam);

}
