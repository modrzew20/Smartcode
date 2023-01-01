package com.example.smartcode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateShapeDto {

    @NonNull
    String type;

    @NonNull
    List<Double> parameters;

}
