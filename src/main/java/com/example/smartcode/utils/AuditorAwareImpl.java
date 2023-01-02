package com.example.smartcode.utils;

import com.example.smartcode.entity.Account;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
        //TODO: implement this method after security is implemented
        return Optional.of(new Account());
    }
}
