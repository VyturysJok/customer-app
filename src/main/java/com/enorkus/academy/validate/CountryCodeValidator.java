package com.enorkus.academy.validate;

import com.enorkus.academy.entity.CountryCode;
import com.enorkus.academy.exception.ValidationException;

public class CountryCodeValidator extends Validator<String> {

    @Override
    public void validate(String attribute, String message) {
        if (!attribute.trim().isEmpty()) {
            boolean allowed = false;
            for (CountryCode country : CountryCode.values()) {
                if (country.toString().equals(attribute)) {
                    allowed = true;
                }
            }
            if (!allowed) {
                throw new ValidationException("Country " + attribute + message);
            }
        }
    }
}
