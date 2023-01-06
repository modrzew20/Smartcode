package com.example.smartcode.unitTests.repository;

import com.example.smartcode.entity.shape.Circle;
import com.example.smartcode.entity.shape.Shape;
import com.example.smartcode.exception.InvalidParameterException;
import com.example.smartcode.repository.ShapeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShapeCustomRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShapeRepository shapeCustomRepository;


    @BeforeEach
    void init() {
        createCircle(2.3);
    }

    @Test
    void getAllTest() throws InvalidParameterException {
        List<Shape> shapes = shapeCustomRepository.findAll(Map.of("type", "circle"));
        assertEquals(1, shapes.size());
    }

    private void createCircle(Double radius) {
        Circle circle = new Circle();
        circle.setType("circle");
        circle.setRadius(radius);
        circle.setCreatedAt(LocalDateTime.now());
        circle.setCreatedBy("test-user");
        circle.setLastModifiedAt(LocalDateTime.now());
        circle.setLastModifiedBy("test-user");

        entityManager.persist(circle);
        entityManager.flush();
    }


}
