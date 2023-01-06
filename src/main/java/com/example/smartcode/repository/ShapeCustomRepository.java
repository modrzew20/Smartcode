package com.example.smartcode.repository;

import com.example.smartcode.entity.figure.Shape;

import java.util.List;
import java.util.Map;

public interface ShapeCustomRepository {

    List<Shape> getAll(Map<String, String> params);
}
