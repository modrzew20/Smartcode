package com.example.smartcode.mapper;

import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.entity.figure.Shape;
import org.springframework.plugin.core.Plugin;

public interface ShapeMapper extends Plugin<String> {

    //todo DRY!!!!!
    GetShapeDto mapShapeToGetShapeDto(Shape shape);

}
