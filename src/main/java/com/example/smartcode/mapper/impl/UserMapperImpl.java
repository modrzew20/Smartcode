package com.example.smartcode.mapper.impl;

import com.example.smartcode.dto.get.GetUserDto;
import com.example.smartcode.entity.Account;
import com.example.smartcode.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public GetUserDto mapAccountToGetUserDto(Account account) {
        GetUserDto dto = new GetUserDto();
        dto.setId(account.getId());
        dto.setFirstName(account.getFirstName());
        dto.setLastName(account.getLastName());
        dto.setLogin(account.getLogin());
        dto.setRole(account.getRole().getName());
        dto.setAmountOfFigures(account.getFigures().size());
        return dto;
    }
}
