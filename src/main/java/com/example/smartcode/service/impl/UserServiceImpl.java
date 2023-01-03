package com.example.smartcode.service.impl;

import com.example.smartcode.dto.CreateUserDto;
import com.example.smartcode.entity.Account;
import com.example.smartcode.entity.Role;
import com.example.smartcode.exception.LoginIsBusyException;
import com.example.smartcode.exception.RoleNotFoundException;
import com.example.smartcode.repository.RoleRepository;
import com.example.smartcode.repository.UserRepository;
import com.example.smartcode.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Page<Account> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Account create(CreateUserDto entity) throws LoginIsBusyException, RoleNotFoundException {
        throwIfUserExists(entity.getLogin());
        Role role = roleRepository.findById(entity.getRole()).orElseThrow(() -> new RoleNotFoundException(entity.getRole()));
        return userRepository.save(getAccount(entity, role));
    }

    private Account getAccount(CreateUserDto entity, Role role) {
        Account account = new Account();
        account.setLogin(entity.getLogin());
        account.setPassword(passwordEncoder.encode(entity.getPassword()));
        account.setRole(role);
        account.setFirstName(entity.getFirstName());
        account.setLastName(entity.getLastName());
        return account;
    }

    private void throwIfUserExists(String login) throws LoginIsBusyException {
        if (userRepository.findByLogin(login).isPresent()) {
            throw new LoginIsBusyException(login);
        }
    }
}
