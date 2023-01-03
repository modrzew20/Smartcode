package com.example.smartcode.repository.impl;

import com.example.smartcode.dto.SearchShapeParam;
import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.repository.ShapeCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShapeCustomRepositoryImpl implements ShapeCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shape> getAll(SearchShapeParam searchShapeParam) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shape> query = cb.createQuery(Shape.class);
        Root<Shape> root = query.from(Shape.class);

        List<Predicate> predicates = new ArrayList<>();
        getByType(searchShapeParam.getType(), cb, root).ifPresent(predicates::add);

        TypedQuery<Shape> typedQuery = entityManager.createQuery(query.select(root).where(predicates.toArray(new Predicate[0])));
        return typedQuery.getResultList();

    }

    private Optional<Predicate> getByType(String type, CriteriaBuilder cb, Root<Shape> root) {
        if (StringUtils.hasText(type)) {
            return Optional.ofNullable(cb.like(cb.lower(root.get("type")), type.toLowerCase()));
        }
        return Optional.empty();
    }

}
