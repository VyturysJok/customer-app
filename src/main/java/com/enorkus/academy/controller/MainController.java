package com.enorkus.academy.controller;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    CustomerService customers;

    public MainController() {
        this.customers = new CustomerService();
    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return customers.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        customers.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customers.deleteCustomer(customerId);
    }

    @RequestMapping("/cars")
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", 100, "red", false, Arrays.asList("Compact", "Deluxe")));
        cars.add(new Car("BMW", 150, "blue", false, Arrays.asList("Compact", "Deluxe")));
        cars.add(new Car("Toyota", 200, "black", true, Arrays.asList("Compact", "Deluxe")));
        return cars;
    }

    public class Car {
        private String model;
        private int speed;
        private String color;
        private boolean isFast;
        private List<String> modifications;

        public Car(String model, int speed, String color, boolean isFast, List<String> modifications) {
            this.model = model;
            this.speed = speed;
            this.color = color;
            this.isFast = isFast;
            this.modifications = modifications;
        }

        public String getModel() {
            return model;
        }

        public int getSpeed() {
            return speed;
        }

        public String getColor() {
            return color;
        }

        public boolean isFast() {
            return isFast;
        }

        public List<String> getModifications() {
            return modifications;
        }
    }
}