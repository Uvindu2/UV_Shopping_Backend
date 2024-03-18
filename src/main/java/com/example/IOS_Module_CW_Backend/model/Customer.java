package com.example.IOS_Module_CW_Backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number")
    private String mobile;

    @Column(name = "age")
    private String age;

    @Column(name = "email")
    private String email;

}