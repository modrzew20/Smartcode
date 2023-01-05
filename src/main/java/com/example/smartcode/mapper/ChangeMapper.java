package com.example.smartcode.mapper;

import com.example.smartcode.dto.get.GetChangeDto;
import com.example.smartcode.entity.Change;

public interface ChangeMapper {

    GetChangeDto mapChangeToGetChangesDto(Change change);
}
