package com.example.IOS_Module_CW_Backend.services.impl;

import com.example.IOS_Module_CW_Backend.model.Customer;
import com.example.IOS_Module_CW_Backend.repository.CustomerRepository;
import com.example.IOS_Module_CW_Backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findByUserName(String customerName) {
        return customerRepository.findCustomerByName(customerName);

    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            return customerRepository.save(customer);
        } else {
            System.out.println("Customer id is not available this id: " + customer.getId());
        }

        return customer;
    }
}
