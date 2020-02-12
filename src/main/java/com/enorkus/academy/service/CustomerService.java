package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validate.CustomerValidator;
import org.springframework.util.StringUtils;

import java.util.List;

public class CustomerService {
    CustomerRepository customerRepository;
    CustomerValidator customerValidator;

    public CustomerService() {
        customerRepository = new MemoryCustomerRepository();
        customerValidator = new CustomerValidator();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        customerValidator.validate(customer);
        customerRepository.insert(formatData(customer));
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private Customer formatData(Customer customer) {
        return new Customer.CustomerBuilder(capitalizeString(customer.getFirstName())
                , capitalizeString(customer.getLastName()), formatPersonalNumber(customer.getPersonalNumber()))
                .age(customer.getAge()).city(customer.getCity()).countryCode(customer.getCountryCode())
                .employer(customer.getEmployer()).gender(customer.getGender()).maritalStatus(customer.getMaritalStatus())
                .middleName(customer.getMiddleName()).monthlyIncome(customer.getMonthlyIncome()).build();
    }

    private String capitalizeString(String stringToCapitalize) {
        return StringUtils.capitalize(stringToCapitalize);
    }

    private String formatPersonalNumber(String personalNumber) {
        StringBuilder formattedNumber = new StringBuilder(personalNumber);
        if (personalNumber.length() > 4 && formattedNumber.charAt(4) != '-') {
            formattedNumber.insert(4, "-");
        }
        return formattedNumber.toString();
    }
}
