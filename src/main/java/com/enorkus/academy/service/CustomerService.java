package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import org.springframework.util.StringUtils;

import java.util.List;

public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new MemoryCustomerRepository();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        customerRepository.insert(formatData(customer));
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private Customer formatData(Customer customer) {
        customer.setFirstName(capitalizeString(customer.getFirstName()));
        customer.setLastName(capitalizeString(customer.getLastName()));
        customer.setPersonalNumber(formatPersonalNumber(customer.getPersonalNumber()));
        return customer;
    }

    private String capitalizeString(String stringToCapitalize) {
        return StringUtils.capitalize(stringToCapitalize);
    }

    private String formatPersonalNumber(String personalNumber) {
        StringBuilder formattedNumber = new StringBuilder(personalNumber);
        if (personalNumber.length() > 4) {
            formattedNumber.insert(4, "-");
        }
        return formattedNumber.toString();
    }
}
