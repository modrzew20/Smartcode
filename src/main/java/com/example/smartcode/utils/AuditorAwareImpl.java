package com.example.smartcode.utils;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //TODO: implement this method after security is implemented
        return Optional.of("admin");
    }
}
