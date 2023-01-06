package com.example.smartcode.mapper.impl;

import com.example.smartcode.common.AbstractShapeMapper;
import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.dto.get.GetSquareDto;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.entity.figure.Square;
import com.example.smartcode.mapper.ShapeMapper;
import org.springframework.stereotype.Component;

@Component
public class SquareMapperImpl extends AbstractShapeMapper implements ShapeMapper {
    @Override
    public GetShapeDto mapShapeToGetShapeDto(Shape shape) {
        GetSquareDto dto = new GetSquareDto();
        mapShape(shape, dto);
        dto.setWidth(((Square) shape).getWidth());
        return dto;
    }

    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("square");
    }
}
