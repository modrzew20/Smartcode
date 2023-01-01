package com.example.smartcode.controller;

import com.example.smartcode.dto.CreateShapeDto;
import com.example.smartcode.entity.figure.Shape;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/shapes")
public interface ShapeController {

    @PostMapping
    ResponseEntity<Shape> create(@RequestBody @Validated CreateShapeDto dto);

}
