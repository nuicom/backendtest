package com.springboog.backendtest.validation;

import com.springboog.backendtest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniqueValidator implements ConstraintValidator<UsernameUnique, String> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void initialize(UsernameUnique constraintAnnotation) {
        //We not need data from annotation.
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        if (username == null || username.length() == 0) {
            return true;
        }

        return !accountRepository.findOneByUsernameAndIsEnabled(username).isPresent();
    }

}
