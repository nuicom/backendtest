package com.springboog.backendtest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SalaryLessValidator.class)
public @interface SalaryLess {
    String message() default "salary < 15,000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
