package com.example.smartcode.controller.impl;

import com.example.smartcode.controller.ShapeController;
import com.example.smartcode.dto.CreateShapeDto;
import com.example.smartcode.dto.get.GetShapeDto;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.exception.InvalidAmountOfParametersException;
import com.example.smartcode.exception.NegativeParametersException;
import com.example.smartcode.mapper.ShapeMapper;
import com.example.smartcode.service.ShapeService;
import com.example.smartcode.utils.EtagGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class ShapeControllerImpl implements ShapeController {

    private final PluginRegistry<ShapeService, String> pluginServiceRegistry;
    private final PluginRegistry<ShapeMapper, String> pluginMapperRegistry;
    private final EtagGenerator etagGenerator;

    @Override
    public ResponseEntity<GetShapeDto> create(CreateShapeDto createShapeDto) {
        try {
            ShapeService shapeService = pluginServiceRegistry.getPluginFor(createShapeDto.getType().toLowerCase())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Shape type is not supported"));

            ShapeMapper shapeMapper = pluginMapperRegistry.getPluginFor(createShapeDto.getType().toLowerCase())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Shape type is not supported"));

            Shape shape = shapeService.create(createShapeDto.getParameters());

            return ResponseEntity.status(201)
                    .eTag(etagGenerator.generateETag(shape))
                    .body(shapeMapper.mapShapeToGetShapeDto(shape));

        } catch (NegativeParametersException | InvalidAmountOfParametersException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
