package com.example.smartcode.mapper;

import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.entity.figure.Shape;
import jakarta.validation.constraints.NotNull;
import org.springframework.plugin.core.Plugin;

public interface ShapeMapper extends Plugin<String> {

    GetShapeDto mapShapeToGetShapeDto(@NotNull Shape shape);

}
