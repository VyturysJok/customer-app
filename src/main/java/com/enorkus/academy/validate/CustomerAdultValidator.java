package com.enorkus.academy.validate;

import com.enorkus.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator<Integer> {

    @Override
    public void validate(Integer attribute, String message) {
        if (attribute < 18) {
            throw new ValidationException("You must be an adult (over 18)");
        }
    }
}
