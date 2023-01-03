package com.example.smartcode.repository;

import com.example.smartcode.dto.SearchShapeParam;
import com.example.smartcode.entity.figure.Shape;

import java.util.List;

public interface ShapeCustomRepository {

    List<Shape> getAll(SearchShapeParam searchShapeParam);
}
