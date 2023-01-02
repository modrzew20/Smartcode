package com.example.smartcode.mapper.impl;

import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.dto.get.GetSquareDto;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.entity.figure.Square;
import com.example.smartcode.mapper.ShapeMapper;
import org.springframework.stereotype.Component;

@Component
public class SquareMapperImpl implements ShapeMapper {
    @Override
    public GetShapeDto mapShapeToGetShapeDto(Shape shape) {
        GetSquareDto dto = new GetSquareDto();
        dto.setArea(shape.getArea());
        dto.setPerimeter(shape.getPerimeter());
        dto.setId(shape.getId());
        dto.setVersion(shape.getVersion());
        dto.setCreatedBy(shape.getCreatedBy());
        dto.setCreatedAt(shape.getCreatedAt());
        dto.setLastModifiedAt(shape.getLastModifiedAt());
        dto.setLastModifiedBy(shape.getLastModifiedBy());
        dto.setType(shape.getType());
        dto.setWidth(((Square) shape).getSide());
        return dto;
    }

    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("square");
    }
}
