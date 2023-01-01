package com.example.smartcode.repository;


import com.example.smartcode.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Account, UUID> {

}
