package com.example.smartcode.controller;

import com.example.smartcode.dto.CreateShapeDto;
import com.example.smartcode.dto.get.GetChangeDto;
import com.example.smartcode.dto.get.GetShapeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/shapes")
public interface ShapeController {

    @PostMapping
    @Secured("ROLE_CREATOR")
    ResponseEntity<GetShapeDto> create(@RequestBody @Validated CreateShapeDto dto);

    @GetMapping("/{id}/changes")
    @Secured({"ROLE_CREATOR", "ROLE_ADMIN"})
    ResponseEntity<List<GetChangeDto>> getChanges(@PathVariable("id") UUID id);

}
