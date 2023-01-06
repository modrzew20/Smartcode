package com.example.smartcode.mapper;

import com.example.smartcode.dto.get.GetChangeDto;
import com.example.smartcode.entity.Change;
import jakarta.validation.constraints.NotNull;

public interface ChangeMapper {

    GetChangeDto mapChangeToGetChangesDto(@NotNull Change change);
}
