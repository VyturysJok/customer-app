package com.enorkus.academy.validate;

import com.enorkus.academy.exception.ValidationException;

public class MandatoryValueValidator extends Validator<String> {
    @Override
    public void validate(String attribute, String message) {
        if (attribute.trim().isEmpty()) {
            throw new ValidationException("Please insert your " + message);
        }
    }
}
