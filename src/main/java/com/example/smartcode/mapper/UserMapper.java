package com.example.smartcode.mapper;

import com.example.smartcode.dto.CreateUserDto;
import com.example.smartcode.dto.get.GetUserDto;
import com.example.smartcode.entity.Account;
import org.springframework.stereotype.Component;


public interface UserMapper {

    GetUserDto mapAccountToGetUserDto(Account account);

}
