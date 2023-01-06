package com.example.smartcode.mapper.impl;

import com.example.smartcode.common.AbstractShapeMapper;
import com.example.smartcode.dto.get.GetRectangleDto;
import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.entity.figure.Rectangle;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.mapper.ShapeMapper;
import org.springframework.stereotype.Component;

@Component
public class RectangleMapperImpl extends AbstractShapeMapper implements ShapeMapper {
    @Override
    public GetShapeDto mapShapeToGetShapeDto(Shape shape) {
        GetRectangleDto dto = new GetRectangleDto();
        mapShape(shape, dto);
        dto.setWidth(((Rectangle) shape).getWidth());
        dto.setLength(((Rectangle) shape).getLength());
        return dto;
    }

    @Override
    public boolean supports(String delimiter) {
        return delimiter.equals("rectangle");
    }
}
