package com.example.IOS_Module_CW_Backend.Controller;

import com.example.IOS_Module_CW_Backend.model.Customer;
import com.example.IOS_Module_CW_Backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> findAllCustomers() {
        return customerService.allCustomer();
    }

    @GetMapping("/findByUserName/{username}")
    public Optional<Customer> findByUserName(@PathVariable String username) {
        return customerService.findByUserName(username);
    }

    @PostMapping("/add")
    public Customer addAllCustomers(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/update")
    public Customer updateCustomerById(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
}
