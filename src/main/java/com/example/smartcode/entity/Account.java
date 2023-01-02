package com.example.smartcode.entity;

import com.example.smartcode.common.AbstractEntity;
import com.example.smartcode.entity.figure.Shape;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Account extends AbstractEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    private Role role;

    @OneToMany
    @Setter(AccessLevel.NONE)
    private List<Shape> figures = new ArrayList<>();
}