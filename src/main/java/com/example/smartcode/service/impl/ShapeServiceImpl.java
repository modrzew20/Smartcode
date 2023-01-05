package com.example.smartcode.service.impl;

import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.exception.ShapeNotFoundException;
import com.example.smartcode.repository.ShapeRepository;
import com.example.smartcode.service.ShapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShapeServiceImpl implements ShapeService {

    private final ShapeRepository shapeRepository;

    @Override
    public Shape get(UUID id) throws ShapeNotFoundException {
        return shapeRepository.findById(id).orElseThrow(() -> new ShapeNotFoundException(id));
    }
}
