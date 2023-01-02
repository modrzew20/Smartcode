package com.example.smartcode.dto.get;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
public class GetUserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String login;
    private String role;
    private int amountOfFigures;
}
