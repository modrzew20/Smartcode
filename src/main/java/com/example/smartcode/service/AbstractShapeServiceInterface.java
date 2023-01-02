package com.example.smartcode.service;

import com.example.smartcode.entity.figure.Shape;
import org.springframework.plugin.core.Plugin;

import java.util.List;

public interface AbstractShapeServiceInterface extends Plugin<String> {

    Shape create(List<Double> parameters);

}
