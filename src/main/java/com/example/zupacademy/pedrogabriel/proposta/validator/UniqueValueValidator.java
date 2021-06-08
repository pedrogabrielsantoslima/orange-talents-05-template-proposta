package com.example.zupacademy.pedrogabriel.proposta.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String fieldName;
    private Class<?> modelClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        modelClass = constraintAnnotation.model();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery(String.format("SELECT 1 FROM %s WHERE %s = :value", modelClass.getSimpleName(), fieldName));
        query.setParameter("value", value);

        return query.getResultList().isEmpty();
    }
}
