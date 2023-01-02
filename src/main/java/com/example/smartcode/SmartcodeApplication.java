package com.example.smartcode;

import com.example.smartcode.service.AbstractShapeServiceInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@SpringBootApplication
@EnablePluginRegistries(AbstractShapeServiceInterface.class)
public class SmartcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartcodeApplication.class, args);
	}

}
