package com.example.smartcode.repository.impl;

import com.example.smartcode.entity.figure.Shape;
import com.example.smartcode.exception.InvalidParameterException;
import com.example.smartcode.repository.ShapeCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShapeCustomRepositoryImpl implements ShapeCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shape> getAll(Map<String, String> params) throws InvalidParameterException {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Shape> query = cb.createQuery(Shape.class);
            Root<Shape> root = query.from(Shape.class);

            List<Predicate> predicates = new ArrayList<>();
            for (Map.Entry<String, String> param : params.entrySet()) {
                if (param.getKey().contains("To")) {
                    Predicate predicate = getLessOrEqualPredicate(cb, root, param.getKey(), param.getValue());
                    predicates.add(predicate);
                } else if (param.getKey().contains("From")) {
                    Predicate predicate = getGreaterOrEqualPredicate(cb, root, param.getKey(), param.getValue());
                    predicates.add(predicate);
                } else {
                    predicates.add(cb.equal(root.get(param.getKey()), param.getValue().toLowerCase()));
                }
            }
            TypedQuery<Shape> typedQuery = entityManager.createQuery(query.select(root).where(predicates.toArray(new Predicate[0])));
            return typedQuery.getResultList();
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException();
        }
    }

    private Predicate getLessOrEqualPredicate(CriteriaBuilder cb, Root<Shape> root, String key, String value) {
        int splitIndex = key.indexOf("To");
        String attributeName = key.substring(0, splitIndex);
        return cb.lessThanOrEqualTo(root.get(attributeName), value);
    }

    private Predicate getGreaterOrEqualPredicate(CriteriaBuilder cb, Root<Shape> root, String key, String value) {
        int splitIndex = key.indexOf("From");
        String attributeName = key.substring(0, splitIndex);
        return cb.greaterThanOrEqualTo(root.get(attributeName), value);
    }


}
