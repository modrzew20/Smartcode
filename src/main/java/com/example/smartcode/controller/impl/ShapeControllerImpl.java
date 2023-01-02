package com.example.smartcode.controller.impl;

import com.example.smartcode.controller.ShapeController;
import com.example.smartcode.dto.CreateShapeDto;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.service.AbstractShapeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ShapeControllerImpl implements ShapeController {

    private final PluginRegistry<AbstractShapeServiceInterface,String> pluginRegistry;


    @Override
    public ResponseEntity<Shape> create(CreateShapeDto createShapeDto) {
        AbstractShapeServiceInterface shapeService = pluginRegistry.getPluginFor(createShapeDto.getType())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Shape type is not supported"));
        return ResponseEntity.ok().body(shapeService.create(createShapeDto.getParameters()));
    }
}
