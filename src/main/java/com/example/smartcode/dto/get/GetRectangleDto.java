package com.example.smartcode.dto.get;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetRectangleDto extends GetShapeDto {

    private double length;

    private double width;

}
