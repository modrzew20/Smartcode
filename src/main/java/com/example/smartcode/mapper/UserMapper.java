package com.example.smartcode.mapper;

import com.example.smartcode.dto.get.GetUserDto;
import com.example.smartcode.entity.User;


public interface UserMapper {

    GetUserDto mapUserToGetUserDto(User user);

}
