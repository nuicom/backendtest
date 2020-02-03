package com.springboog.backendtest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SalaryLessValidator implements ConstraintValidator<SalaryLess, Integer> {

    @Override
    public void initialize(SalaryLess constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value >= 15000;
    }
}
