package com.enorkus.academy.validate;

import com.enorkus.academy.entity.Customer;

public class CustomerValidator {
    public void validate(Customer customer) {
        Validator mandatoryValidator = new MandatoryValueValidator();
        mandatoryValidator.validate(customer.getFirstName(), "Please enter your first name");
        mandatoryValidator.validate(customer.getLastName(), "Please enter your last name");
        mandatoryValidator.validate(customer.getPersonalNumber(), "Please enter your personal number");
        Validator adultValidator = new CustomerAdultValidator();
        adultValidator.validate(customer.getAge(), "You have to be over 18 to apply");
        Validator countryValidator = new CountryCodeValidator();
        countryValidator.validate(customer.getCountryCode(), " is not allowed");
    }


}
