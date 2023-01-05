package com.example.smartcode.service;

import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.exception.ShapeNotFoundException;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.UUID;

public interface ShapeService {

    @PostAuthorize("(hasRole('ROLE_CREATOR') && returnObject.createdBy == authentication.name) || hasRole('ROLE_ADMIN')")
    Shape get(UUID id) throws ShapeNotFoundException;
}
