package com.example.smartcode;

import com.example.smartcode.mapper.ShapeMapper;
import com.example.smartcode.service.ShapeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@EnablePluginRegistries({ShapeService.class, ShapeMapper.class})
public class SmartcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartcodeApplication.class, args);
    }

}
