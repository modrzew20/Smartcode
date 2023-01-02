package com.example.smartcode.service;

import com.example.smartcode.dto.CreateUserDto;
import com.example.smartcode.entity.Account;
import com.example.smartcode.exception.LoginIsBusyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<Account> getAll(Pageable pageable);

    Account create(CreateUserDto entity) throws LoginIsBusyException;



}
