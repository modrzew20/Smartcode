package com.example.smartcode.controller.impl;

import com.example.smartcode.controller.ShapeController;
import com.example.smartcode.dto.CreateShapeDto;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.service.impl.CircleServiceImpl;
import com.example.smartcode.service.impl.RectangleServiceImpl;
import com.example.smartcode.service.impl.SquareServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShapeControllerImpl implements ShapeController {

    private final RectangleServiceImpl rectangleService;
    private final SquareServiceImpl squareService;
    private final CircleServiceImpl circleService;

    @Override
    public ResponseEntity<Shape> create(CreateShapeDto createShapeDto) {
        //TODO change switch
        return switch (createShapeDto.getType().toLowerCase()) {
            case "rectangle" -> ResponseEntity.ok().body(rectangleService.create(createShapeDto.getParameters()));
            case "square" -> ResponseEntity.ok().body(squareService.create(createShapeDto.getParameters()));
            case "circle" -> ResponseEntity.ok().body(circleService.create(createShapeDto.getParameters()));
            default -> ResponseEntity.badRequest().build();
        };
    }
}
