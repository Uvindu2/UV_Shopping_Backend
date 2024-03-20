package com.example.IOS_Module_CW_Backend.services;

import com.example.IOS_Module_CW_Backend.model.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    List<Customer> allCustomer();

    Optional<Customer> findByUserName(String customerName);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

}
