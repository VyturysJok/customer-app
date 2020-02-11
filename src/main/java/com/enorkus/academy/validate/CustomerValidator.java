package com.enorkus.academy.validate;

import com.enorkus.academy.entity.CountryCode;
import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.exception.CustomerNotAdultException;
import com.enorkus.academy.exception.InvalidCountryCodeException;
import com.enorkus.academy.exception.MandatoryValueMissingException;

public class CustomerValidator {
    public void validateCustomer(Customer customer) {
        validateMandatoryValues(customer.getFirstName(), customer.getLastName(), customer.getPersonalNumber());
        validateAge(customer.getAge());
        if (!customer.getCountryCode().trim().isEmpty()) {
            validateCountryCode(customer.getCountryCode());
        }
    }

    private void validateMandatoryValues(String firstName, String lastName, String personalNumber) throws MandatoryValueMissingException {
        validateMandatoryValue(firstName, "first name");
        validateMandatoryValue(lastName, "last name");
        validateMandatoryValue(personalNumber, "personal number");
    }

    private void validateMandatoryValue(String mandatoryValue, String errorMessage) {
        if (mandatoryValue.trim().isEmpty()) {
            throw new MandatoryValueMissingException("Please insert your " + errorMessage);
        }
    }

    private void validateAge(int age) throws CustomerNotAdultException {
        if (age < 18) {
            throw new CustomerNotAdultException("You must be an adult (over 18)");
        }
    }

    private void validateCountryCode(String countryCode) throws InvalidCountryCodeException {
        boolean allowed = false;
        for (CountryCode country : CountryCode.values()) {
            if (country.toString().equals(countryCode)) {
                allowed = true;
            }
        }
        if (!allowed) {
            throw new InvalidCountryCodeException("Country " + countryCode + " is not allowed");
        }
    }
}
