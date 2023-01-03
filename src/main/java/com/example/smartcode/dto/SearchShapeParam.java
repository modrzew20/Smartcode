package com.example.smartcode.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class SearchShapeParam {

    String type;

    double minArea;

    double maxArea;

    double minPerimeter;

    double maxPerimeter;

    LocalDateTime minCreatedAt;

    LocalDateTime maxCreatedAt;

    String login;

    String minWidth;

    String maxWidth;

    String minHeight;

    String maxHeight;

    String minRadius;

    String maxRadius;

}
