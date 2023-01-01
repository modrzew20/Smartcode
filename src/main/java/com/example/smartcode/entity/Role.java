package com.example.smartcode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Role {

    public static final String ADMIN = "ADMIN";
    public static final String CREATOR = "CREATOR";

    @Id
    private String name;

}
