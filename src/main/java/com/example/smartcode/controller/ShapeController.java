package com.example.smartcode.controller;

import com.example.smartcode.dto.CreateShapeDto;
import com.example.smartcode.dto.SearchShapeParam;
import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.entity.figure.Shape;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/shapes")
public interface ShapeController {

    @PostMapping
    @Secured("ROLE_CREATOR")
    ResponseEntity<GetShapeDto> create(@RequestBody @Validated CreateShapeDto dto);


    @GetMapping
    ResponseEntity<List<Shape>> getAll(SearchShapeParam searchShapeParam);
}
