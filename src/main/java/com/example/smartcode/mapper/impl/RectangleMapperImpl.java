package com.example.smartcode.mapper.impl;

import com.example.smartcode.dto.get.GetRectangleDto;
import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.entity.figure.Rectangle;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.mapper.ShapeMapper;
import org.springframework.stereotype.Component;

@Component
public class RectangleMapperImpl implements ShapeMapper {
    @Override
    public GetShapeDto mapShapeToGetShapeDto(Shape shape) {
        GetRectangleDto dto = new GetRectangleDto();
        dto.setArea(shape.getArea());
        dto.setPerimeter(shape.getPerimeter());
        dto.setId(shape.getId());
        dto.setVersion(shape.getVersion());
        dto.setCreatedBy(shape.getCreatedBy());
        dto.setCreatedAt(shape.getCreatedAt());
        dto.setLastModifiedAt(shape.getLastModifiedAt());
        dto.setLastModifiedBy(shape.getLastModifiedBy());
        dto.setType(shape.getType());
        dto.setWidth(((Rectangle) shape).getWidth());
        dto.setLength(((Rectangle) shape).getLength());
        return dto;
    }

    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("rectangle");
    }
}
