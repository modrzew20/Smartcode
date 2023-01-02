package com.example.smartcode.controller.impl;

import com.example.smartcode.controller.UserController;
import com.example.smartcode.dto.CreateUserDto;
import com.example.smartcode.dto.PaginationParam;
import com.example.smartcode.dto.get.GetUserDto;
import com.example.smartcode.exception.LoginIsBusyException;
import com.example.smartcode.mapper.UserMapper;
import com.example.smartcode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<Page<GetUserDto>> getAll(PaginationParam paginationParam) {
        return ResponseEntity
                .ok()
                .body(userService.getAll(PageRequest.of(paginationParam.getPage(), paginationParam.getSize())).map(userMapper::mapAccountToGetUserDto));
    }

    @Override
    public ResponseEntity<GetUserDto> create(CreateUserDto createUserDto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userMapper.mapAccountToGetUserDto(userService.create(createUserDto)));
        } catch (LoginIsBusyException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
