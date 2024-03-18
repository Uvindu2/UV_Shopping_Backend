package com.example.IOS_Module_CW_Backend.services;

import com.example.IOS_Module_CW_Backend.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    List<Customer> allCustomer();

    Customer addCustomer(Customer customer);

}
