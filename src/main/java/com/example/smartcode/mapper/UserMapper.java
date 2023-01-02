package com.example.smartcode.mapper;

import com.example.smartcode.dto.get.GetUserDto;
import com.example.smartcode.entity.Account;


public interface UserMapper {

    GetUserDto mapAccountToGetUserDto(Account account);

}
