package com.example.IOS_Module_CW_Backend.repository;

import com.example.IOS_Module_CW_Backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByUsername(String username);
}
