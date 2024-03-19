package com.example.IOS_Module_CW_Backend.repository;

import com.example.IOS_Module_CW_Backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
