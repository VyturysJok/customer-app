package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;

public class ValidatorService {
    public static boolean validate(Customer customer) {
        validateFirstName(customer.getFirstName());
        validateLastName(customer.getLastName());
        validatePersonalNumber(customer.getPersonalNumber());
        validateAge(customer.getAge());
    }

    private static boolean validateFirstName(String firstName) {

    }
    private static boolean validateLastName(String lastName) {

    }
    private static boolean validatePersonalNumber(String personalNumber) {

    }
    private static boolean validateAge(int age) {

    }
}
