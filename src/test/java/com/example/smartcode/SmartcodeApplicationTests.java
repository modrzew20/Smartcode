package com.example.smartcode;

import com.example.smartcode.exception.InvalidParameterException;
import com.example.smartcode.repository.ShapeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SmartcodeApplicationTests {

	@Autowired
	private ShapeRepository shapeRepository;

	@Test
	void contextLoads() {
		assertThrows(InvalidParameterException.class, () -> shapeRepository.getAll(Map.of("type1", "circle")));

	}

}
